package com.yatharth.jobportal.spring_boot_job_portal_app.interfaces;

import com.yatharth.jobportal.spring_boot_job_portal_app.model.JobPostModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchRepoImplements implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPostModel> findByText(String text) {
        final List<JobPostModel> jobPosts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("job_portal_db");
        MongoCollection<Document> collection = database.getCollection("job_posts");

        // Ensure text index exists: { profile: "text", techs: "text", desc: "text" }
        Document searchQuery = new Document("$text", new Document("$search", text));
        Document sortQuery = new Document("exp", -1);

        // try (MongoCursor<Document> cursor = collection.find(searchQuery).sort(sortQuery).limit(5).iterator()) {
        try (MongoCursor<Document> cursor = collection.find(searchQuery).sort(sortQuery).iterator()) {
            while (cursor.hasNext()) {
                jobPosts.add(converter.read(JobPostModel.class, cursor.next()));
            }
        }

        return jobPosts;
    }
}
