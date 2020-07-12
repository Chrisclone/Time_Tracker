package Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM IndividualActivity")
    List<IndividualActivity> getAll();

    @Insert
    void insertAll(IndividualActivity... activity);

    @Delete
    void delete(IndividualActivity activity);
}
