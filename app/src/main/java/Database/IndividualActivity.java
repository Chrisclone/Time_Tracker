package Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class IndividualActivity {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "activity_name")
    public String activityName;

    @ColumnInfo(name = "activity_type")
    public String activityType;
}
