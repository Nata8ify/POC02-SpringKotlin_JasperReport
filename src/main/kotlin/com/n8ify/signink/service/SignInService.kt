package com.n8ify.signink.service

import com.n8ify.signink.model.SignIn
import com.n8ify.signink.model.SignInFindByIdRequest
import com.n8ify.signink.model.SignInFindByUserIdRequest
import com.n8ify.signink.model.SignInUpdateRequest
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.math.BigInteger

interface SignInService {

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    fun update(signInUpdateRequest : SignInUpdateRequest)

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    fun delete(signInUpdateRequest : SignInUpdateRequest)

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    fun findById(signInFindByIdRequest: SignInFindByIdRequest) : SignIn?

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    fun findByUserId(signInFindByIdRequest: SignInFindByUserIdRequest) : List<SignIn>?

}