package bridges.base;

import bridges.validation.InvalidValueException;

/**
 * 
 * @author Kalpathi Subramanian
 *
 * @param <E>
 *
 * @brief This class can be used to create arrays of type Element<E> where E 
 *	is a generic type representation application specific data.  
 *	Arrays are internally represented as 1D arrays; currently 1D, 2D  and
 *	3D arrays are supported.
 *
 * @author 	Kalpathi Subramanian
 * @date  	10/8/16
 *
 */
public class Array<E> extends DataStruct {
	private Element<E>[] array_data;
	private int num_dims;					// only 2D and 3D arrays supported
	private int[] dims = {1, 1, 1};					// array dimensions
	private int size;						// array size
	
	/*
	 * Construct a default array object
	 */
	public Array() {
		array_data = null;
		num_dims = 1;
		dims[0] = dims[1] = dims[2] = size = 0;
	}
	/**
	 *  Create an array object with the specified dimensions
	 *
	 *  @param num_dims number of dimensions of the array
	 *  @param dims size of each dimension
     *
	 */
	public Array(int num_dims, int[] dims) {
		setNumDimensions(num_dims);
		setDimensions(dims);
	}
	/**
	 *	This method gets the data structure type
	 *
	 *	@return  The date structure type as a string
	 */
	public String getDataStructType() {
		if ((num_dims >= 1) && (num_dims <= 3))
			return "Array";
		else {
			throw new InvalidValueException("Invalid number of dimensions. Only 1D, 2D and 3D arrays supported at this time");			
		}
	}
	/**
	 *	
	 *	Set the number of dimensions of the array; 
	 *
	 *	@param nd  number of dimensions
	 */

	public void setNumDimensions(int nd) {
		if (nd > 3) {
			throw new InvalidValueException("Invalid number of dimensions. Only 1D, 2D and 3D arrays supported at this time"); 
		}
		num_dims = nd;
	}
	/**
	 *	
	 *	Get the number of dimensions of the array; 
	 *
	 *	@return   number of dimensions
	 */

	public int getNumDimensions() {
		if (num_dims > 3) {
			throw new InvalidValueException("Invalid number of dimensions. Only 1D, 2D and 3D  arrays supported at this time"); 
		}
		return num_dims;
	}

	/**
	 *	
	 *	Set the size of each dimensions; also allocates  array space
	 *
	 *	@param dim[]  size of each dimension
	 */
	public void setDimensions(int[] dim) {
		int sz = 1;
		for (int k = 0; k < num_dims; k++) {
			dims[k] = dim[k];
			sz *= dim[k];
		}
                            // first check the dimensions are all positive
		if (sz < 0) {
			throw new InvalidValueException("Invalid dimension value, must be  positive");
		}
		size = sz;
                            // allocate space for the array 
		array_data = new Element[size];  
		for (int k = 0; k < size; k++)
			array_data[k] = new Element<E>();
	}
	/**
	 *	
	 *	Get the size of each dimensions; 
	 *
	 *	@param dims[]  size of each dimension is returned
	 */
	public void getDimensions(int[] dim) {
		dim[0] = dims[0];
		dim[1] = dims[1];
		dim[2] = dims[2];
	}

	/**
	 *	
	 *	Get the array size
	 *
	 *	@return size
	 */
	public int  getSize() {
		return size;
	}

	/**
	 *	
	 *	Get the object at 'indx' 
	 *
	 *	@param indx  index into the array
	 *	@return Element<E>  object at 'indx'
	 */
	public Element<E> getValue(int indx) {
		return array_data[indx];
	}

	/**
	 *	
	 *	Set the input object at 'indx' 
	 *
	 *	@param indx  index into the array
	 *	@param el  element object to be assigned at 'indx'
	 *
	 *
	 **/
	public void setValue(int indx, Element<E> el) {
		array_data[indx] = el;
	}
	/**
	 *	
	 *	2D array: Get the object at 'col, row' 
	 *
	 *	@param col  col index into the array
	 *	@param row  row index into the array
	 *
	 *	@return Element<E>  object at 'col, row'
	 */
	public Element<E> getValue(int col, int row) {
		return array_data[row*dims[0] + col];
	}

	/**
	 *	
	 *	Set the input object at 'indx' 
	 *	@param col  column index into the array
	 *	@param row  row index into the array
	 *	@param el  element object to be assigned at 'indx'
	 *
	 *
	 */
	public void setValue(int col, int row, Element<E> el) {
		array_data[row*dims[0]+col] = el;
	}

	/**
	 *	
	 *	3D array: Get the object at 'col, row, slice' 
	 *
	 *	@param col col index into the array
	 *	@param row  row index into the array
	 *	@param slice  slice index into the array
	 *
	 *	@return Element<E>  object at 'col, row'
	 */
	public Element<E> getValue(int col, int row, int slice) {
		return array_data[slice*dims[0]*dims[1] + row*dims[0] + col];
	}
	/**
	 *	
	 *	Set the input object at 'col, row, slice' 
	 *
	 *	@param col  column index into the array
	 *	@param row  row index into the array
	 *	@param slice  slice index into the array
	 *
	 *	@param el  element object to be assigned at 'indx'
	 *
	 */
	public void setValue(int col, int row, int slice, Element<E> el) {
		array_data[slice*dims[0]*dims[1] + row*dims[0] +col] = el;
	}
}