package com.reus.restwsasync.interfaceimpl

import com.reus.restwsasync.interfaces.CheckProcessor
import com.reus.restwsasync.model.CheckList
import org.springframework.stereotype.Service
import javax.ws.rs.BadRequestException
import javax.ws.rs.container.AsyncResponse
import kotlin.concurrent.thread

@Service
open class CheckProcessorImpl : CheckProcessor {
    override fun processChecks(response: AsyncResponse, checkList: CheckList) {
        thread {
            // It never is empty for some reason :(
            if (validateCheckList(checkList)) {
                response.resume(true)
            } else {
                response.resume(BadRequestException())
            }
        }
    }

    private fun validateCheckList(checkList: CheckList): Boolean {
        return when {
            checkList.checks.isEmpty() -> false
            checkList.checks[0].accountNumber.isEmpty() -> false
            checkList.checks[0].checkNumber.isEmpty() -> false
            checkList.checks[0].amount == 0.0 -> false
            else -> true
        }
    }
}