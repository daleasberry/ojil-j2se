/*
 * Gray8Statistics.java
 *
 * Created on November 11, 2006, 2:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *
 * Copyright 2007 by Jon A. Webb
 *     This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the Lesser GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.ojil.algorithm.j2se;
import com.github.ojil.algorithm.ErrorCodes;
import com.github.ojil.core.Error;
import com.github.ojil.core.Gray8Image;
import com.github.ojil.core.Image;

/**
 * Gray8Statistics is used to measure the mean and variance of a gray
 * image.
 * 
 * 
 * @author webb
 */
public class Gray8Statistics {
    private float fMean; // mean image value
    private float fVariance; // image variance
    
    /**
     * Creates a new instance of Gray8Statistics
     */
    public Gray8Statistics() {
    }
    
    /** Estimate the mean and variance of an input gray image.
     *
     * @param image the input image.
     * @throws com.github.ojil.core.Error if the input image is not gray.
     */
    public void push(Image image) throws com.github.ojil.core.Error
    {
        if (!(image instanceof Gray8Image)) {
            throw new Error(
                			Error.PACKAGE.ALGORITHM,
                			ErrorCodes.IMAGE_NOT_GRAY8IMAGE,
                			image.toString(),
                			null,
                			null);
        }
        Gray8Image gray = (Gray8Image) image;
        int nSum = 0, nSumSq = 0;
        Byte[] data = gray.getData();
        for (int i=0; i<gray.getHeight(); i++) {
            for (int j=0; j<gray.getWidth(); j++) {
                int pixel = (data[i*image.getWidth()+j]) - Byte.MIN_VALUE;
                nSum += pixel;
                nSumSq += pixel*pixel;
            }
        }
        /** Compute mean and variance. Both are scaled by 256 for accuracy.
         */
        int nCount = image.getHeight() * image.getWidth();
        this.fMean = ((float)nSum) / ((float)nCount);
        // expanded form of variance computation
        // note order of multiplications and divisions. we're trying to
        // avoid overflow here.
        this.fVariance =  
                (nSumSq / (nCount - 1) - 
                    nSum / nCount * nSum  / (nCount - 1));
    }
    
    /** Return computed mean, times 256.
     *
     * @return the mean value, times 256.
     */
    public float getMean() {
        return this.fMean;
    }
    
    /**
     * Return standard deviation, times 256 using Newton's iteration.
     * @return the standard deviation, times 256.
     * @throws com.github.ojil.core.Error if the variance computed in push() is less than zero.
     */
    public float getStdDev() throws com.github.ojil.core.Error {
        float f = getVariance(); // getVariance() 
        if (f < 0) throw new Error(
            			Error.PACKAGE.ALGORITHM,
            			ErrorCodes.STATISTICS_VARIANCE_LESS_THAN_ZERO,
            			new Float(f).toString(),
            			null,
            			null);
        // return sqrt(variance)
        return (float) Math.sqrt(f);
    }
    
    /** Return computed variance.
     *
     * @return the computed variance value.
     */
    public float getVariance() {
        return this.fVariance;
    }
}
