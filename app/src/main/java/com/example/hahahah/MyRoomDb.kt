package com.example.hahahah

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Student::class], version = 1)
//abstract class MyRoomDb : RoomDatabase() {
//    abstract fun studentDao(): StudentDao
//
//    companion object {
//        private var INSTANCE: MyRoomDb? = null
//
//        fun getAppDataBase(context: Context): MyRoomDb? {
//
//            if (INSTANCE == null) {
//                synchronized(MyRoomDb::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        MyRoomDb::class.java,
//                        "myDB"
//                    )
//                        .build()
//                }
//            }
//            return INSTANCE
//        }
//
//        fun destroyDataBase() {
//            INSTANCE = null
//        }
//    }
//}
private const val DB_NAME = "mydb.db"

@Database(entities = [Student::class,ScClass::class],version=1)
abstract class RoomFromMarkMurphy:RoomDatabase(){

    abstract fun studentDao():StudentDao

    companion object{
        @Volatile
        private var INSTANCE:RoomFromMarkMurphy? = null


        @Synchronized
        fun get(context:Context):RoomFromMarkMurphy{
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,RoomFromMarkMurphy::class.java,DB_NAME)
                    .build()
            }
            return INSTANCE!!
        }
    }
}


