package com.davis.business.student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("students")
    Call<List<Student>> getStudents(
            @Query("school") String school,
            @Query("leveal") int leveal
    );

    @DELETE
    void removeStudent(
            @Query("id") int id
    );
}
