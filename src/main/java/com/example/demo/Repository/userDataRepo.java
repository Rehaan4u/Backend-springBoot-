package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.userData;

public interface userDataRepo extends JpaRepository<userData , Integer>
{
    //No methods declared here yet
}
