package com.example.doctor.medication.domain.model

//data class of drug info
data class druginfo(
    val product_ndc: String,
    val marketing_end_date: String,
    val generic_name: String,
    val labeler_name: String,
    val brand_name: String,
    val active_ingredients: List<ActiveIngredient>,
    val finished: Boolean,
    val packaging: List<Packaging>,
    val openfda: OpenFda,
    val marketing_category: String,
    val dosage_form: String,
    val spl_id: String,
    val product_type: String,
    val route: List<String>,
    val marketing_start_date: String,
    val product_id: String,
    val application_number: String,
    val brand_name_base: String,
    val pharm_class: List<String>
)

data class ActiveIngredient(
    val name: String,
    val strength: String
)

data class Packaging(
    val package_ndc: String,
    val description: String,
    val marketing_start_date: String,
    val marketing_end_date: String,
    val sample: Boolean
)

data class OpenFda(
    val manufacturer_name: List<String>,
    val rxcui: List<String>,
    val spl_set_id: List<String>,
    val is_original_packager: List<Boolean>,
    val nui: List<String>,
    val pharm_class_moa: List<String>,
    val pharm_class_cs: List<String>,
    val pharm_class_epc: List<String>,
    val unii: List<String>
)
