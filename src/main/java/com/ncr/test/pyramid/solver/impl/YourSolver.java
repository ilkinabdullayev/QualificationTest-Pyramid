package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 2nd task. 
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int rowCount = pyramid.getRows();
        int[][] data = pyramid.getData();
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < rowCount - i; j++) {
                data[i][j] =  data[i][j] + Math.max(data[i - 1] [j], data[i - 1] [j + 1]);
            }
        }

        return data[rowCount - 1][0];
    }
}
