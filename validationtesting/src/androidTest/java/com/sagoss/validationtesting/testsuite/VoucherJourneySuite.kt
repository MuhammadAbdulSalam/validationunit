/*
 * Copyright (c) 2021. Author Muhammad Abdul Salam.
 * Property of Sagoss Group
 *
 * It is against law to modify, replicate or distribute this code
 * Permission of owner (Sagoss Group) is needed in order to
 * modify, replicate or distribute this code.
 */

package com.sagoss.validationtesting.testsuite

import com.sagoss.validationtesting.tests.ui.apiconfig.registrationlogin.RegistrationJourney
import com.sagoss.validationtesting.tests.ui.apiconfig.vouchers.UserJourneyC2c
import com.sagoss.validationtesting.tests.ui.apiconfig.vouchers.UserJourneyGreaterAnglia
import com.sagoss.validationtesting.tests.ui.apiconfig.vouchers.UserJourneyHorizon
import com.sagoss.validationtesting.tests.ui.dbconfig.AcademyUserJourney
import com.sagoss.validationtesting.tests.ui.dbconfig.ContractorVoucherJourney
import com.sagoss.validationtesting.tests.ui.dbconfig.DisabledVoucherJourney
import com.sagoss.validationtesting.tests.ui.dbconfig.StaffVoucherJourney
import org.junit.runner.RunWith
import org.junit.runners.Suite

// Runs all tests.
@RunWith(Suite::class)
@Suite.SuiteClasses(
    /**
     * Test classes for DB config
     * Stores hardcoded vouchers in DB and test them with voucher journey
     */
    AcademyUserJourney::class,
    StaffVoucherJourney::class,
    ContractorVoucherJourney::class,
    DisabledVoucherJourney::class,

    /**
     * Test classes for Online config
     * Uses API responses to run tests
     */
    RegistrationJourney::class,
    UserJourneyC2c::class,
    UserJourneyGreaterAnglia::class,
    UserJourneyHorizon::class)
class VoucherJourneySuite