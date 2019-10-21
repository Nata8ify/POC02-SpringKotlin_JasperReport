package com.n8ify.signink.service.impl

import com.n8ify.signink.dao.SignInDao
import com.n8ify.signink.model.SignIn
import com.n8ify.signink.model.SignInFindByIdRequest
import com.n8ify.signink.model.SignInFindByUserIdRequest
import com.n8ify.signink.model.SignInUpdateRequest
import com.n8ify.signink.service.SignInService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignInServiceImpl : SignInService {

    @Autowired
    lateinit var signInDao: SignInDao

    override fun update(signInUpdateRequest: SignInUpdateRequest) {

        if(signInUpdateRequest.data.signInId == null){
            signInUpdateRequest.data.apply {
                this@apply.signInId = signInDao.getLatestSignInId()
                signInDao.insert(this@apply)
            }
        } else {
            signInDao.update(signInUpdateRequest.data)
        }

    }

    override fun delete(signInUpdateRequest: SignInUpdateRequest) {

        signInUpdateRequest.data.signInId?.let {
            signInDao.delete(it)
        }

    }

    override fun findById(signInFindByIdRequest: SignInFindByIdRequest): SignIn? {

        return signInFindByIdRequest.data?.let {
            signInDao.findById(it)
        }

    }

    override fun findByUserId(signInFindByIdRequest: SignInFindByUserIdRequest): List<SignIn>? {

        return signInFindByIdRequest.data?.let {
            signInDao.findByUserId(it)
        }

    }
}
