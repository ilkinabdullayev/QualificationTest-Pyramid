package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;
import java.util.Arrays;

/**
 * TASK: There is something wrong here. A few things actually...
 */
public class NaivePyramidSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        //i use in here dynamic programming principle.
        //The idea is to simple store the results of subproblems, so we don’t have to recompute them when needed later.
        // This simple optimization reduces time complexities from exponential to polynomial.
        //this changes for solverSurvivesLargeData test. So it is enhanced a bit for larger inputs
        long dp[][] = new long[pyramid.getRows()][pyramid.getRows()];
        for (long[] row: dp) {
            Arrays.fill(row, -1);
        }

        return getTotalAbove(pyramid.getRows() - 1, 0, dp, pyramid);
    }

    private long getTotalAbove(int row, int column, long dp[][], Pyramid pyramid) {
        if (row == 0) return pyramid.get(row, column);

        if (dp[row][column] != -1) {
            return dp[row][column];
        }

        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalAbove(row - 1, column, dp, pyramid);
        long right = myValue + getTotalAbove(row - 1, column + 1, dp, pyramid);
        return dp[row][column] = Math.max(left, right);
    }
}