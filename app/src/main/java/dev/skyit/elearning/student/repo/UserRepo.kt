package dev.skyit.elearning.student.repo

import dev.skyit.api.LoginTagApi
import dev.skyit.elearning.student.cache.CacheManager
import dev.skyit.model.UserAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserRepo {

    suspend fun login(email: String, pass: String): String
}


class UserRepoImpl(
    private val cacheManager: CacheManager
): UserRepo {
    override suspend fun login(email: String, pass: String): String = withContext(Dispatchers.IO){
        val param = UserAuth(email = email, password = pass)
        val answer = LoginTagApi().loginParam(param)
        cacheManager.loginToken = answer.token!!
        cacheManager.email = email
        answer.email!!
    }
}