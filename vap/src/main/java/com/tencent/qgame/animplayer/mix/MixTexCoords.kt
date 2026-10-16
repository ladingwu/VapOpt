package com.tencent.qgame.animplayer.mix

import com.tencent.qgame.animplayer.PointRect

/** 仅计算可选 imageFrame 的浮点图片 UV，旧素材继续使用原有适配方式。 */
internal object MixTexCoords {
    /**
     * 绘制区域仍是原 frame，仅把图片采样定位到完整参考范围，遮挡时不重新挤压整张 Bitmap。
     * 极小范围导致除法溢出时返回 null，由调用方恢复旧适配方式。复用顶点缓存，不分配逐帧数组。
     */
    fun createWithImageFrame(array: FloatArray, frame: PointRect, imageFrame: MixImageFrame): FloatArray? {
        val left = (frame.x.toFloat() - imageFrame.x) / imageFrame.w
        val top = (frame.y.toFloat() - imageFrame.y) / imageFrame.h
        val right = (frame.x.toFloat() + frame.w - imageFrame.x) / imageFrame.w
        val bottom = (frame.y.toFloat() + frame.h - imageFrame.y) / imageFrame.h
        if (!left.isFinite() || !top.isFinite() || !right.isFinite() || !bottom.isFinite()) return null
        array[0] = left
        array[1] = top
        array[2] = left
        array[3] = bottom
        array[4] = right
        array[5] = top
        array[6] = right
        array[7] = bottom
        return array
    }
}
