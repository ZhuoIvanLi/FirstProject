package myList;

public class MyArrayList extends MyAbstractList {

	public static final int INITIAL_CAPCITY = 16;
	private Object[] data = new Object[INITIAL_CAPCITY];

	// Create a default list
	public MyArrayList() {
		// TODO Auto-generated constructor stub

	}

	// Add a new element o at the specified index in this list
	public MyArrayList(Object[] objects) {
		data = objects;
		size = objects.length;
	}

	@Override
	public void add(int index, Object o) {
		ensureCapacity();

		// Move the elements to the right after the specified index
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}

		// Insert new element to the data[index]
		data[index] = o;

		// Increase size by 1
		size++;

	}

	// Create a new larger array, double the current size
	private void ensureCapacity() {
		if (size >= data.length) {
			Object[] newData = new Object[data.length * 2];
			System.arraycopy(data, 0, newData, 0, data.length);
			data = newData;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data = new Object[INITIAL_CAPCITY];
	}

	@Override
	// Clear the list
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++)
			if (o.equals(data[i]))
				return true;

		return false;
	}

	@Override
	// return true if this list contains the element o
	public Object get(int index) {
		// TODO Auto-generated method stub
		return data[index];

	}

	@Override
	// Return the index of the first matching element in this list
	// Return -1 if no match
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++)
			if (o.equals(data[i]))
				return i;

		return 0;
	}

	@Override
	// Return the index of the last matching element in this list
	// Return -1 if no match
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		for (int i = size - 1; i >= 0; i--)
			if (o.equals(data[i]))
				return i;

		return 0;
	}

	@Override
	// Remove the first occurrence of the element o from this list; Shift any
	// subsequent elements to the left; Return true if the element is removed.
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (o.equals(data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	// Remove the element at the specified position in this list; Shift any
	// subsequent elements to the left; Return the element that was removed from the
	// list.
	public Object remove(int index) {
		// TODO Auto-generated method stub
		Object o = data[index];

		// Shift data to the left
		for (int i = index; i < size - 1; i++)
			data[i] = data[i + 1];

		size--;
		return o;
	}

	@Override
	// Replace the element at the specified position in this list with the specified
	// element
	public Object set(int index, Object o) {
		// TODO Auto-generated method stub
		data[index] = o;

		return o;
	}

	// Override toString() to return elements in the list
	public String toString() {
		StringBuffer result = new StringBuffer("[");

		for (int i = 0; i < size; i++) {
			result.append(data[i]);
			if (i < size - 1)
				result.append(", ");
		}

		return result.toString() + "]";
	}

}
