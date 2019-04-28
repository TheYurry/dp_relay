//package sk.knet.dp.relay
//
//import io.swagger.annotations.ApiOperation
//import io.swagger.annotations.ApiParam
//import javax.annotation.security.RolesAllowed
//import kotlin.String
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.HttpStatus.BAD_REQUEST
//import org.springframework.http.HttpStatus.OK
//import org.springframework.http.ResponseEntity
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestParam
//import org.springframework.web.bind.annotation.RestController
//import org.springframework.web.multipart.MultipartFile
//
//@RestController
//@EnableResourceServer
//class Janko2 {
//    @Autowired
//    lateinit var processServerRequest: ProcessServerRequest
//
//    @PostMapping("Janko2/1/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition1",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun perform1(
//            @PathVariable("instanceId") instanceId: String,
//            @RequestParam(value = "name") @ApiParam(required = true) name: String,
//            @RequestParam(value = "surname") @ApiParam(required = true) surname: String,
//            @RequestParam(value = "date_of_birth") @ApiParam(required = true) date_of_birth: String,
//            @RequestParam(value = "street") @ApiParam(required = true) street: String,
//            @RequestParam(value = "streetnumber") @ApiParam(required = true) streetnumber: String,
//            @RequestParam(value = "postal", defaultValue = "") @ApiParam(required = false)
//            postal: String,
//            @RequestParam(value = "city", defaultValue = "") @ApiParam(required = false, allowableValues
//            = """[]""") city: String,
//            @RequestParam(value = "income") @ApiParam(required = true) income: String,
//            @RequestParam(value = "loan_amount") @ApiParam(required = true) loan_amount: String
//    ): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex(".*").matches(name) ) {
//            errors.add("name" +
//                    " should match .*" )}
//        if ( !Regex(".*").matches(surname) ) {
//            errors.add("surname" +
//                    " should match .*" )}
//        if ( !Regex("(\\d{4})-(\\d{2})-(\\d{2})").matches(date_of_birth) ) {
//            errors.add("date_of_birth" +
//                    " should match (\\d{4})-(\\d{2})-(\\d{2})" )}
//        if ( !Regex(".*").matches(street) ) {
//            errors.add("street" +
//                    " should match .*" )}
//        if ( !Regex(".*").matches(streetnumber) ) {
//            errors.add("streetnumber" +
//                    " should match .*" )}
//        if (postal !=  "" &&  !Regex(".*").matches(postal) ) {
//            errors.add("postal" +
//                    " should match .*" )}
//        if (city !=  "" &&  !Regex("").matches(city) ) {
//            errors.add("city" +
//                    " should match " )}
//        if ( !Regex("\\d+").matches(income) ) {
//            errors.add("income" +
//                    " should match \\d+" )}
//        if ( !Regex("\\d+").matches(loan_amount) ) {
//            errors.add("loan_amount" +
//                    " should match \\d+" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "1",
//                instanceId,
//                mapOf( "name" to name , "surname" to surname , "date_of_birth" to date_of_birth
//                        , "street" to street , "streetnumber" to streetnumber , "postal" to postal ,
//                        "city" to city , "income" to income , "loan_amount" to loan_amount ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/5/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_BUREAU_AGENT")
//    @ApiOperation(
//            value = "Transition5",
//            notes = "Allowed roles: [ROLE_JANKO2_BUREAU_AGENT]"
//    )
//    fun perform5(
//            @PathVariable("instanceId") instanceId: String,
//            @RequestParam(value = "question_mortgage_lates") @ApiParam(required = true)
//            question_mortgage_lates: String,
//            @RequestParam(value = "question_amount") @ApiParam(required = true) question_amount: String,
//            @RequestParam(value = "question_jobs") @ApiParam(required = true) question_jobs: String
//    ): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex("0|1|true|false").matches(question_mortgage_lates) ) {
//            errors.add("question_mortgage_lates" +
//                    " should match 0|1|true|false" )}
//        if ( !Regex("0|1|true|false").matches(question_amount) ) {
//            errors.add("question_amount" +
//                    " should match 0|1|true|false" )}
//        if ( !Regex("0|1|true|false").matches(question_jobs) ) {
//            errors.add("question_jobs" +
//                    " should match 0|1|true|false" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "5",
//                instanceId,
//                mapOf( "question_mortgage_lates" to question_mortgage_lates , "question_amount"
//                        to question_amount , "question_jobs" to question_jobs ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/14/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_LOAN_OFFICER")
//    @ApiOperation(
//            value = "Transition14",
//            notes = "Allowed roles: [ROLE_JANKO2_LOAN_OFFICER]"
//    )
//    fun perform14(@PathVariable("instanceId") instanceId: String, @RequestParam(value =
//    "reject_loanofficer_reason") @ApiParam(required = true)
//    reject_loanofficer_reason: String): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex(".*").matches(reject_loanofficer_reason) ) {
//            errors.add("reject_loanofficer_reason" +
//                    " should match .*" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "14",
//                instanceId,
//                mapOf( "reject_loanofficer_reason" to reject_loanofficer_reason ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/26/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition26",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun perform26(@PathVariable("instanceId") instanceId: String, @RequestParam(value =
//    "reject_underwriter_reason") @ApiParam(required = true)
//    reject_underwriter_reason: String): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex(".*").matches(reject_underwriter_reason) ) {
//            errors.add("reject_underwriter_reason" +
//                    " should match .*" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "26",
//                instanceId,
//                mapOf( "reject_underwriter_reason" to reject_underwriter_reason ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/35/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition35",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun perform35(
//            @PathVariable("instanceId") instanceId: String,
//            @RequestParam(value = "floor") @ApiParam(required = true) floor: String,
//            @RequestParam(value = "type") @ApiParam(required = true, allowableValues = """[House, Flat,
//                Bungalow, Cabin]""") type: String,
//            @RequestParam(value = "years", defaultValue = "") @ApiParam(required = false) years: String,
//            @RequestParam(value = "photo", defaultValue = "") @ApiParam(required = false)
//            photo: MultipartFile
//    ): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex("\\d+").matches(floor) ) {
//            errors.add("floor" +
//                    " should match \\d+" )}
//        if ( !Regex("House|Flat|Bungalow|Cabin").matches(type) ) {
//            errors.add("type" +
//                    " should match House|Flat|Bungalow|Cabin" )}
//        if (years !=  "" &&  !Regex("\\d+").matches(years) ) {
//            errors.add("years" +
//                    " should match \\d+" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "35",
//                instanceId,
//                mapOf( "floor" to floor , "type" to type , "years" to years , "photo" to photo
//                ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/39/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_PROPERTY_APPRAISER")
//    @ApiOperation(
//            value = "Transition39",
//            notes = "Allowed roles: [ROLE_JANKO2_PROPERTY_APPRAISER]"
//    )
//    fun perform39(
//            @PathVariable("instanceId") instanceId: String,
//            @RequestParam(value = "appraisal") @ApiParam(required = true) appraisal: MultipartFile,
//            @RequestParam(value = "appraised_value") @ApiParam(required = true) appraised_value: String,
//            @RequestParam(value = "approved", defaultValue = "") @ApiParam(required = false)
//            approved: String
//    ): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex("\\d+").matches(appraised_value) ) {
//            errors.add("appraised_value" +
//                    " should match \\d+" )}
//        if (approved !=  "" &&  !Regex("0|1|true|false").matches(approved) ) {
//            errors.add("approved" +
//                    " should match 0|1|true|false" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "39",
//                instanceId,
//                mapOf( "appraisal" to appraisal , "appraised_value" to appraised_value ,
//                        "approved" to approved ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/48/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition48",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun perform48(@PathVariable("instanceId") instanceId: String, @RequestParam(value =
//    "delete_case") @ApiParam(required = true) delete_case: String): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if ( !Regex("0|1|true|false").matches(delete_case) ) {
//            errors.add("delete_case" +
//                    " should match 0|1|true|false" )}
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "48",
//                instanceId,
//                mapOf( "delete_case" to delete_case ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/72/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition72",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun perform72(@PathVariable("instanceId") instanceId: String, @RequestParam(value =
//    "confirmation_insurance", defaultValue = "") @ApiParam(required = false)
//    confirmation_insurance: MultipartFile): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "72",
//                instanceId,
//                mapOf( "confirmation_insurance" to confirmation_insurance ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/78/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_ACCOUNT_CLERK")
//    @ApiOperation(
//            value = "Transition78",
//            notes = "Allowed roles: [ROLE_JANKO2_ACCOUNT_CLERK]"
//    )
//    fun perform78(@PathVariable("instanceId") instanceId: String, @RequestParam(value = "payment",
//            defaultValue = "") @ApiParam(required = false) payment: MultipartFile):
//            ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "78",
//                instanceId,
//                mapOf( "payment" to payment ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/92/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition92",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun perform92(@PathVariable("instanceId") instanceId: String, @RequestParam(value =
//    "confirmation_mortgage", defaultValue = "") @ApiParam(required = false)
//    confirmation_mortgage: MultipartFile): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "92",
//                instanceId,
//                mapOf( "confirmation_mortgage" to confirmation_mortgage ))
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/94/{instanceId}/finish")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition94",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun perform94(@PathVariable("instanceId") instanceId: String, @RequestParam(value =
//    "confirmation_insurance", defaultValue = "") @ApiParam(required = false)
//    confirmation_insurance: MultipartFile): ResponseEntity<String> {
//        val errors = mutableListOf<String>()
//        if(errors.isNotEmpty()){
//            return ResponseEntity(errors.toString(), BAD_REQUEST)
//        }
//        processServerRequest.perform("Janko2",
//                "94",
//                instanceId,
//                mapOf( "confirmation_insurance" to confirmation_insurance ))
//        return ResponseEntity("", OK)
//    }
//
//    @GetMapping("Janko2/5/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_BUREAU_AGENT")
//    @ApiOperation(
//            value = "Transition5",
//            notes = "Allowed roles: [ROLE_JANKO2_BUREAU_AGENT]"
//    )
//    fun view5(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "5",
//                instanceId)
//        return get5Result()
//    }
//
//    @GetMapping("Janko2/30/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition30",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun view30(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "30",
//                instanceId)
//        return get30Result()
//    }
//
//    @GetMapping("Janko2/39/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_PROPERTY_APPRAISER")
//    @ApiOperation(
//            value = "Transition39",
//            notes = "Allowed roles: [ROLE_JANKO2_PROPERTY_APPRAISER]"
//    )
//    fun view39(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "39",
//                instanceId)
//        return get39Result()
//    }
//
//    @GetMapping("Janko2/53/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_LOAN_OFFICER")
//    @ApiOperation(
//            value = "Transition53",
//            notes = "Allowed roles: [ROLE_JANKO2_LOAN_OFFICER]"
//    )
//    fun view53(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "53",
//                instanceId)
//        return get53Result()
//    }
//
//    @GetMapping("Janko2/59/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition59",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun view59(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "59",
//                instanceId)
//        return get59Result()
//    }
//
//    @GetMapping("Janko2/61/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition61",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun view61(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "61",
//                instanceId)
//        return get61Result()
//    }
//
//    @GetMapping("Janko2/72/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition72",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun view72(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "72",
//                instanceId)
//        return get72Result()
//    }
//
//    @GetMapping("Janko2/78/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_ACCOUNT_CLERK")
//    @ApiOperation(
//            value = "Transition78",
//            notes = "Allowed roles: [ROLE_JANKO2_ACCOUNT_CLERK]"
//    )
//    fun view78(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "78",
//                instanceId)
//        return get78Result()
//    }
//
//    @GetMapping("Janko2/96/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition96",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun view96(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "96",
//                instanceId)
//        return get96Result()
//    }
//
//    @GetMapping("Janko2/155/{instanceId}")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition155",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun view155(@PathVariable("instanceId") instanceId: String) {
//        processServerRequest.get("Janko2",
//                "155",
//                instanceId)
//        return get155Result()
//    }
//
//    @PostMapping("Janko2/1/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition1",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign1(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "1",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/5/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_BUREAU_AGENT")
//    @ApiOperation(
//            value = "Transition5",
//            notes = "Allowed roles: [ROLE_JANKO2_BUREAU_AGENT]"
//    )
//    fun assign5(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "5",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/9/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_LOAN_OFFICER")
//    @ApiOperation(
//            value = "Transition9",
//            notes = "Allowed roles: [ROLE_JANKO2_LOAN_OFFICER]"
//    )
//    fun assign9(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "9",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/14/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_LOAN_OFFICER")
//    @ApiOperation(
//            value = "Transition14",
//            notes = "Allowed roles: [ROLE_JANKO2_LOAN_OFFICER]"
//    )
//    fun assign14(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "14",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/18/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition18",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign18(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "18",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/23/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition23",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun assign23(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "23",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/26/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition26",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun assign26(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "26",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/30/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition30",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun assign30(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "30",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/35/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition35",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign35(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "35",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/39/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_PROPERTY_APPRAISER")
//    @ApiOperation(
//            value = "Transition39",
//            notes = "Allowed roles: [ROLE_JANKO2_PROPERTY_APPRAISER]"
//    )
//    fun assign39(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "39",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/48/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition48",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign48(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "48",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/53/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_LOAN_OFFICER")
//    @ApiOperation(
//            value = "Transition53",
//            notes = "Allowed roles: [ROLE_JANKO2_LOAN_OFFICER]"
//    )
//    fun assign53(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "53",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/59/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_UNDERWRITER")
//    @ApiOperation(
//            value = "Transition59",
//            notes = "Allowed roles: [ROLE_JANKO2_UNDERWRITER]"
//    )
//    fun assign59(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "59",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/61/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition61",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign61(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "61",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/72/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition72",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign72(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "72",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/78/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_ACCOUNT_CLERK")
//    @ApiOperation(
//            value = "Transition78",
//            notes = "Allowed roles: [ROLE_JANKO2_ACCOUNT_CLERK]"
//    )
//    fun assign78(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "78",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/92/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition92",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign92(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "92",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/94/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition94",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign94(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "94",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/96/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition96",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign96(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "96",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    @PostMapping("Janko2/155/{instanceId}/assign")
//    @RolesAllowed("ROLE_JANKO2_CLIENT")
//    @ApiOperation(
//            value = "Transition155",
//            notes = "Allowed roles: [ROLE_JANKO2_CLIENT]"
//    )
//    fun assign155(@PathVariable("instanceId") instanceId: String): ResponseEntity<String> {
//        processServerRequest.assign("Janko2",
//                "155",
//                instanceId)
//        return ResponseEntity("", OK)
//    }
//
//    class get5Result(
//            name: String = "",
//            surname: String = "",
//            income: String = "",
//            loan_amount: String = "",
//            score: String = ""
//    )
//
//    class get30Result(
//            name: String = "",
//            surname: String = "",
//            income: String = "",
//            loan_amount: String = "",
//            question_mortgage_lates: String = "",
//            question_amount: String = "",
//            question_jobs: String = "",
//            score: String = ""
//    )
//
//    class get39Result(
//            floor: String = "",
//            type: String = "",
//            years: String = "",
//            photo: String = ""
//    )
//
//    class get53Result(
//            name: String = "",
//            surname: String = "",
//            date_of_birth: String = "",
//            street: String = "",
//            streetnumber: String = "",
//            postal: String = "",
//            city: String = "",
//            income: String = "",
//            loan_amount: String = ""
//    )
//
//    class get59Result(confirmation_insurance: String = "", insurance: String = "")
//
//    class get61Result(
//            name: String = "",
//            surname: String = "",
//            date_of_birth: String = "",
//            street: String = "",
//            streetnumber: String = "",
//            postal: String = "",
//            city: String = "",
//            income: String = "",
//            loan_amount: String = "",
//            sign: String = ""
//    )
//
//    class get72Result(insurance: String = "")
//
//    class get78Result(loan_amount: String = "")
//
//    class get96Result(payment: String = "")
//
//    class get155Result(status: String = "")
//}
