
package bridges.base;

import bridges.base.Symbol;
import org.json.simple.JSONObject;
import java.util.ArrayList;

/**
 * @brief This class defines a polygon and is part of the symbol collection.
 *		A polygon has a sequence of points (x, y coordinate pairs)
 *
 * Basic styling such as stroke and fill are defined in the superclass Symbol.
 *
 * @author David Burlinson, Kalpathi Subramanian
 * @date 12/23/18, 7/15/19
 *
 */
public class Polygon extends Polyline {

	/**
	 *	 Construct a default polygon structure
	 */
	public Polygon () {
		super();
		this.setShapeType("polygon");
	}

	/**
	 *	 Construct a polygon with the give set of points
	 */
	public Polygon (ArrayList<Float>  pts) {
		super(pts);
		this.setShapeType("polygon");
	}

	/**
	 *	This method gets the name of the shape
	 *
	 *  @return name   shape name
	 */
	public String getName() {
		return "polygon";
	}

};

