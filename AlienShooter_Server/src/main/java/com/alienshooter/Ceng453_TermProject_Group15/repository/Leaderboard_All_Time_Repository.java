package com.alienshooter.Ceng453_TermProject_Group15.repository;

import com.alienshooter.Ceng453_TermProject_Group15.model.Leaderboard_All_Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;

@Repository
public interface Leaderboard_All_Time_Repository extends JpaRepository<Leaderboard_All_Time,Long> {

    /*
    This updates Leaderboard_All_Time table in our database.
    When a player's score is updated it updates the leaderboard accordingly.
     */
    @Transactional
    @Modifying
    @Query("UPDATE Leaderboard_All_Time SET date = :date,score_ = :score WHERE user_id = :id")
    void score_update(@Param("id") long id,@Param("score") long score,@Param("date") Date date);

    /*
    This gets the user's score according to the id given.
     */
    @Query("SELECT u FROM Leaderboard_All_Time u WHERE user_id = :id")
    Leaderboard_All_Time get_by_userid(@Param("id") long id);

}
