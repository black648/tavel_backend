package com.travel.domain.common.code.domain

import com.travel.global.entity.BooleanConverter
import jakarta.persistence.*

@Entity
@Table(name = "codeGroup")
class CodeGroup(
    val maxLevel: Int,
    val orderNo: Int,
    val name: String,
    val description: String,

    @Convert(converter = BooleanConverter::class)
        val useAble: Boolean,

    @OneToMany(mappedBy = "codeGroup", cascade = [CascadeType.ALL], orphanRemoval = true)
        val codeList: List<Code> = mutableListOf(),

    @Id
        @Column(name = "groupCd")
        val groupCd: String
) {

}