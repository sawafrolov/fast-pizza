package com.github.sawafrolov.fastpizza.iamproxy.services

import com.github.sawafrolov.fastpizza.common.dto.iam.ChangePasswordDto
import com.github.sawafrolov.fastpizza.common.dto.iam.LoginDto
import com.github.sawafrolov.fastpizza.common.dto.iam.RegistrationDto
import java.util.UUID

interface IamService {

    fun register(registrationDto: RegistrationDto): UUID

    fun login(loginDto: LoginDto): UUID

    fun changePassword(changePasswordDto: ChangePasswordDto)
}
