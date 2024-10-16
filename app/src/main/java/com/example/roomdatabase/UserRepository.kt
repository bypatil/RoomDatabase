package com.example.roomdatabase

import androidx.room.RoomDatabase

class UserRepository(private val userDao: UserDao) {

    fun insertUser(user: User){
        //run insert operation in a seperate thread
        Thread{
            userDao.insertUser(user)
        }.start()
    }

    fun updateUser(user: User){
        //run update operation in a seperate theread
        Thread{
            userDao.updateUser(user)
        }.start()
    }

    fun deleteUser(user: User){
        //run delete opeartion in a seperate theread
        Thread{
            userDao.deleteUser(user)
        }.start()

    }

    fun getAllUsers(callback: (List<User>) -> Unit){
        //run query operation in a seperate therad
        Thread{
            val users = userDao.getAllUsers()
            //pass the result back to the callback
            callback(users)
        }.start()
    }
}