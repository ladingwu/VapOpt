package com.tencent.qgame.animplayer.mix

/**
 * 完整 Bitmap 在内容坐标系中的浮点映射范围，独立于可见遮罩的 frame/mFrame。
 * 仅离线修正素材的 img + fitXY 使用该扩展；其他适配方式、未提供或数值无效时继续使用原路径。
 */
data class MixImageFrame private constructor(val x: Float, val y: Float, val w: Float, val h: Float) {
    companion object {
        fun create(x: Float, y: Float, w: Float, h: Float): MixImageFrame? {
            if (!x.isFinite() || !y.isFinite() || !w.isFinite() || !h.isFinite() || w <= 0f || h <= 0f ||
                !(x + w).isFinite() || !(y + h).isFinite()
            ) return null
            return MixImageFrame(x, y, w, h)
        }
    }
}
