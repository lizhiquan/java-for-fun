/**
 * Assignment1
 * Copyright (c) 2019 Vincent Le. All rights reserved.
 * Created by Vincent Le on 2019-09-30.
 */
package ca.bcit.comp2526.assignment1;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.InvocationTargetException;

/**
 * The driver program.  Displays the specified shape with
 * the specifified width/height values in the specified manner (console
 * or JFrame).
 * 
 */
public class Main
{
    /**
     * The smallest value to width/height
     */
    private static final int MIN_VALUE = 1;

    /**
     * The largest value to width/height
     */
    private static final int MAX_VALUE = 100;

    /**
     * Disallow the creation of any Main objects.
     */
    private Main()
    {
    }

    /**
     * The entry point to the program.
     *
     * @param argv the command line args.
     *        argv[0] - the type (r,t,d,s,Rt)
     *        argv[1] - the width value (> 1 && < 100)
     *        argv[2] - the height value (> 1 && < 100)
     *        argv[3] - the displayer type (ConsoleDisplayer, 
     *                                      SwingDisplayer)
     */
    public static void main(final String[] argv)
    {
        final int       expectedArgs = 4;
        final int       typeArg      = 0;
        final int       startArg     = 1;
        final int       stopArg      = 2;    
        final int       displayerArg = 3;    

        final String  type;
        final Shape      shape;
        final Displayer  displayer;
        final int        start;
        final int        stop;
        
        if(argv.length != expectedArgs)
        {
            usage("Wrong number of arguments");
        }

        type = getType(argv[typeArg]);
        start = getNumber(argv[startArg]);
        stop = getNumber(argv[stopArg]);
        shape = getShape(type, start, stop);
        displayer = getDisplayer(argv[displayerArg]);
        displayer.displayShape(shape);
    }
	
	/**
	* Creates the desired shape given the type, width and height
	*  @param type defines the type of shape to create
	*		  width gives the width to be used - certain shapes must have odd width size
	*		  height gives the height to be used - not used for all shapes
	*  @return Shape desired shape or NULL if unable to create
	**/
	public static Shape getShape(final String    type,
                                 final int       width,
                                 final int       height)
    {
        Shape shape = null;
        Class[] args = new Class[2];
		args[0] = int.class;
		args[1] = int.class;
		String typePath = "ca.bcit.comp2526.assignment1." + type;

		try {
			shape = (Shape)Class.forName(typePath).getDeclaredConstructor(args).newInstance(width, height);
		}
		catch(final ClassNotFoundException ex)
        {
            usage("Cannot find class: " + type);
			return null;
        }
        catch(final InstantiationException ex)
        {
            System.err.println("Error creating: " + type);
            return null;
        }
        catch(final IllegalAccessException ex)
        {
            System.err.println(type + " must have a public, no-arg, constructor");
            return null;
        }
		catch(final NoSuchMethodException ex){}
		catch(final InvocationTargetException ex){
			if (ex.getCause().toString() == "BadWidthException"){
				usage("Bad Width");
				return null;
			}
		}
        
        return (shape);
    }    

	/**
	*	Determines the desired enum type of shape from the string provided
	*	@param str a single letter defining the shape
	*	@return ShapeType an enum type representing the shape
	**/
       public static String getType(final String str)
    {
        final Map<String, String> shapeMap;
        final String type;

        shapeMap = new HashMap<String, String>();
        shapeMap.put("r", "Rectangle");
        shapeMap.put("t", "Triangle");
        shapeMap.put("d", "Diamond");
        shapeMap.put("s", "Square");
        shapeMap.put("Rt", "RTriangle");
        

        type = shapeMap.get(str);

        if (type == null) {
            usage("No such shape: " + str);
        }

        return (type);
    }
 
    
    /**
     * Convert the supplied string into an int. 
     * If the string is not a valid int then exit the program.
     * To be valid the string must be an integer and be > MIN_VALUE 
     * and < MAX_VALUE.
     *
     * @param str the string to convert
     * @return the converted number
     */
    public static int getNumber(final String str)
    {
        int val;
        
        try
        {
            val = Integer.parseInt(str);
            
            if(val < 1 || val > 100)
            {
                usage("Value out of range: " + val);
            }
        }
        catch(NumberFormatException ex)
        {
            usage("Not a number: " + str);
            val = 0;
        }
        
        return (val);
    }
    
    /**
     * Create the appropriate displayer. 
     *
     * @param name the class name of the displayer to create
     * @return the newly created displayer
     */
    public static Displayer getDisplayer(final String name)
    {
        // COMP 2526 NOTE: This is part of "reflection"
        // What we are doing is converting the string
        // into an instance of a class at runtime!
        try
        {
            String namePath = "ca.bcit.comp2526.assignment1." + name;
            return ((Displayer)Class.forName(namePath).getDeclaredConstructor().newInstance());
        }
        catch(final ClassNotFoundException ex)
        {
            usage("Cannot find class: " + name);
        }
        catch(final InstantiationException ex)
        {
            System.err.println("Error creating: " + name);
            System.exit(1);
        }
        catch(final IllegalAccessException ex)
        {
            System.err.println(name + " must have a public, no-arg, constructor");
            System.exit(1);
        }
		catch(final NoSuchMethodException ex){}
		catch(final InvocationTargetException ex){}
        
        return (null);
    }
    
    /**
     * Display the usage message and exit the program.
     */
    public static void usage(final String msg)
    {
        System.err.println(msg);
        System.err.println("Usage: Main <type> <start> <stop> <displayer>");
        System.err.println("\tWhere <type> is one of: r, t, d, s, Rt");
        System.err.println("\tand <width> is between 1 and 100");
        System.err.println("\tand <height> is between 1 and 100");
        System.err.println("\tand <displayer> is one of: ConsoleDisplayer, GUIDisplayer");
		System.err.println("\tTriangle and Diamond must have uneven width, height not used");
		System.err.println("\tSquare only uses width");
        System.exit(1);
    }            
}
