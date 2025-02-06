package com.github.sawafrolov.fastpizza.iamproxy.services

import com.github.sawafrolov.fastpizza.common.dto.iam.ChangePasswordDto
import com.github.sawafrolov.fastpizza.common.dto.iam.LoginDto
import com.github.sawafrolov.fastpizza.common.dto.iam.RegistrationDto
import com.github.sawafrolov.fastpizza.common.util.test.correctCustomerShortDto
import java.util.UUID

class FakeIamService: IamService {

    override fun register(registrationDto: RegistrationDto): UUID =
        correctCustomerShortDto.uuid

    override fun login(loginDto: LoginDto): UUID =
        correctCustomerShortDto.uuid

    override fun changePassword(changePasswordDto: ChangePasswordDto): UUID =
        correctCustomerShortDto.uuid
}
