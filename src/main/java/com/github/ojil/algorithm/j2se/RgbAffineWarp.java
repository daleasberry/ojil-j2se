/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.ojil.algorithm.j2se;

import com.github.ojil.algorithm.ErrorCodes;
import com.github.ojil.algorithm.Gray3Bands2Rgb;
import com.github.ojil.algorithm.RgbSelectGray;
import com.github.ojil.core.Error;
import com.github.ojil.core.Gray8OffsetImage;
import com.github.ojil.core.Image;
import com.github.ojil.core.PipelineStage;
import com.github.ojil.core.RgbImage;
import com.github.ojil.core.RgbOffsetImage;

/**
 * Copyright 2008 by Jon A. Webb
 * @author webb
 */
public class RgbAffineWarp extends PipelineStage {
    private Gray8AffineWarp grayWarp;
    private RgbSelectGray selectRed, selectGreen, selectBlue;
    
    public RgbAffineWarp(double[][] warp) throws Error {
        this.grayWarp = new Gray8AffineWarp(warp);
        this.selectRed = new RgbSelectGray(RgbSelectGray.RED);
        this.selectGreen = new RgbSelectGray(RgbSelectGray.GREEN);
        this.selectBlue = new RgbSelectGray(RgbSelectGray.BLUE);
    }
    
    @Override
    public void push(Image imageInput) throws Error {
        if (!(imageInput instanceof RgbImage)) {
            throw new Error(
    				Error.PACKAGE.ALGORITHM,
    				ErrorCodes.IMAGE_NOT_RGBIMAGE,
    				imageInput.toString(),
    				null,
    				null);
        }
        this.selectRed.push(imageInput);
        this.grayWarp.push(this.selectRed.getFront());
        Gray8OffsetImage warpedRed = (Gray8OffsetImage) this.grayWarp.getFront();
        this.selectGreen.push(imageInput);
        this.grayWarp.push(this.selectGreen.getFront());
        Gray8OffsetImage warpedGreen = (Gray8OffsetImage) this.grayWarp.getFront();
        this.selectBlue.push(imageInput);
        this.grayWarp.push(this.selectBlue.getFront());
        Gray8OffsetImage warpedBlue = (Gray8OffsetImage) this.grayWarp.getFront();
        RgbImage rgb = Gray3Bands2Rgb.push(warpedRed, warpedGreen, warpedBlue);
        super.setOutput(new RgbOffsetImage(
                rgb, 
                warpedRed.getXOffset(), 
                warpedRed.getYOffset()));
    }

    public void setWarp(double[][] warp) throws Error {
        this.grayWarp.setWarp(warp);
    }
    
    public Vec2 warpVec(Vec2 v) {
        return this.grayWarp.warpVec(v);
    }
}
