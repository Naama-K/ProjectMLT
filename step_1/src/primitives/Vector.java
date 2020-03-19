package primitives;

import primitives.*;

public class Vector 
{
	//fields
	Point3D _head;
	
	//constructors
	public Vector()
	{
		_head = new Point3D();
	}
	public Vector(Point3D head)
	{
		_head = new Point3D(head);
	}
	public Vector(Vector v)
	{
		_head = new Point3D(v._head);
	}
	public Vector(double a, double b, double c)
	{
		this._head = new Point3D(new Coordinate(a), new Coordinate(b), new Coordinate(c));
	}
	public Vector(Point3D p1, Point3D p2)
	{
		Coordinate x = new Coordinate(p2.get_x().get_coordinate()-p1.get_x().get_coordinate());
		Coordinate y = new Coordinate(p2.get_y().get_coordinate()-p1.get_y().get_coordinate());
		Coordinate z = new Coordinate(p2.get_z().get_coordinate()-p1.get_z().get_coordinate());
		_head = new Point3D(x, y, z);
	}


	//equals
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}
	
	//toString
	public String toString() 
	{
		return "" + _head;
	}

	//other functions:
	public void subtract(Vector v)
	{
		this._head.subtract(v);
	}
	public void add(Vector v)
	{
		this._head.add(v);
	}
	
	public double dotProduct(Vector vector) // skalar_mult
	{
		return (this._head.get_x().get_coordinate() * vector._head.get_x().get_coordinate() + this._head.get_y().get_coordinate() * vector._head.get_y().get_coordinate() + this._head.get_z().get_coordinate() * vector._head.get_z().get_coordinate());
	}
	
	public void scale(double t)
	{
		this._head.set_x(new Coordinate(t * this._head.get_x().get_coordinate()));
		this._head.set_y(new Coordinate(t * this._head.get_y().get_coordinate()));
		this._head._z=new Coordinate(t * this._head._z.get_coordinate());
	}
	
	public double length()
	{
		Point3D help = new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
		return _head.distance(help);
	}
	
	public void normalize()
	{
		double l = length();
		this.scale(1/l);
	}
	
	public Vector crossProduct(Vector v)
	{
		double i = _head.get_y().get_coordinate() * v._head.get_z().get_coordinate() - _head.get_z().get_coordinate() * v._head.get_y().get_coordinate(); 
		double j = (-1)*(_head.get_x().get_coordinate() * v._head.get_z().get_coordinate() - _head.get_z().get_coordinate() * v._head.get_x().get_coordinate()); 
		double k = _head.get_x().get_coordinate() * v._head.get_y().get_coordinate() - _head.get_y().get_coordinate() * v._head.get_x().get_coordinate(); 
		return new Vector (new Point3D(new Coordinate(i), new Coordinate(j), new Coordinate(k)));
	}
	public Point3D get_head() {
		return new Point3D(_head);
	}
}
