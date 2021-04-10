/*
 * Copyright 2019 Andrew Rice <acr31@cam.ac.uk>, C.I. Griffiths
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.cig23.matrices;

/** A static class for constructing matrices with 2d shapes. */
class Shapes {

  /**
   * Create a new 2x2 matrix which applies a rotation
   *
   * @param degrees to rotate by
   * @return a 2x2 matrix
   */
  static Matrix rotation2d(double degrees) {
    degrees = degrees * Math.PI / 180;
    double[][] elements = new double[][] {
            {Math.cos(degrees),-Math.sin(degrees)},
            {Math.sin(degrees),Math.cos(degrees)}
    };
    return new Matrix(elements);

  }

  /** Create a new identity matrix with the specified size. */
  static Matrix identity(int size) {
    double[][] data = new double[size][size];
    for (int i = 0; i < size; i++) {
      data[i][i] = 1;
    }
    return new Matrix(data);
  }

  /**
   * Create a new matrix representing the points on the circumference of a square centred on (0,0).
   *
   * @param size the length of half an edge i.e. the square will run from -size to size
   * @return a matrix of height 2 with each column representing a point on the square
   */
  static Matrix square(int size) {
    double[][] points = new double[2][size*8];
    //x coords
    for(int i = 0; i<size*2;i++) {
      points[0][i] = -size;
    }
    for(int i = size*2; i<size*4;i++) {
      points[0][i] = size;
    }
    for(int i = size*4; i<size*6;i++) {
      points[0][i] = i-size*4-size;
      points[0][i+size*2] = i-size*4-size+1;
    }
    //y coords
    for(int i = size*4; i<size*6;i++) {
      points[1][i] = -size;
    }
    for(int i = size*6; i<size*8;i++) {
      points[1][i] = size;
    }
    for(int i = 0; i<size*2;i++) {
      points[1][i] = i-size+1;
      points[1][i+size*2] = i-size;
    }
    return new Matrix(points);
  }

  // No instances
  private Shapes() {}
}
