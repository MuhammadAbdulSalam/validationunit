/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.testsuite

import com.sagoss.validationtesting.tests.ui.dbconfig.AcademyUserJourney
import com.sagoss.validationtesting.tests.ui.dbconfig.ContractorVoucherJourney
import com.sagoss.validationtesting.tests.ui.dbconfig.StaffVoucherJourney
import org.junit.runner.RunWith
import org.junit.runners.Suite

// Runs all unit tests.
@RunWith(Suite::class)
@Suite.SuiteClasses(
    AcademyUserJourney::class,
    StaffVoucherJourney::class,
    ContractorVoucherJourney::class)
class VoucherJourneySuite