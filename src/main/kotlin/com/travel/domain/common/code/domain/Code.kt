package com.travel.domain.common.code.domain

import com.travel.global.entity.BooleanConverter
import jakarta.persistence.*

@IdClass(CodePk::class)
@Entity
@Table(name = "code")
class Code constructor(

        val parentCd: String,
        val level: Int,
        val orderNo: Int,
        val name: String,
        val description: String,

        @Convert(converter = BooleanConverter::class)
        val useAble: Boolean,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "groupCd", insertable = false, updatable = false)
        val codeGroup: CodeGroup? = null,

        @Id
        val cd: String,

        @Id
        @Column(name = "groupCd")
        val groupCd: String
){

}