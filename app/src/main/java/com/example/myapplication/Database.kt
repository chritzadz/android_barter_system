import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.myapplication.model.User
import com.example.myapplication.model.UserDao

@Database(
    entities = [User::class],
    version = 1
)
abstract class Database: RoomDatabase() {
    abstract val dao: UserDao
}