package lotto.domain

@JvmInline
value class LottoNumber private constructor(private val value: Int) {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private val cache = (MIN_NUMBER..MAX_NUMBER).associateBy { it }

        fun from(number: Int): LottoNumber? {
            require(number in MIN_NUMBER..MAX_NUMBER) {
                "로또 번호는 $MIN_NUMBER~$MAX_NUMBER 사이여야 합니다. number: $number"
            }
            return cache[number]?.let { LottoNumber(it) }
        }
    }
}