/*
 * ============================================================================
 * Copyright © 2002-2020 by Thomas Thrien.
 * All Rights Reserved.
 * ============================================================================
 * Licensed to the public under the agreements of the GNU Lesser General Public
 * License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.tquadrat.foundation.svg;

import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.lang.Objects.requireNonNullArgument;
import static org.tquadrat.foundation.svg.SVGUtils.number;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue;

/**
 *  The definition for the SVG {@code <rect>} element.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGRectangle.java 980 2022-01-06 15:29:19Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGRectangle.java 980 2022-01-06 15:29:19Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface SVGRectangle extends SVGElementWithChildren, AllowsConditionalProcessingAttributes, AllowsGlobalEventAttributes, AllowsGraphicalEventAttributes, AllowsPresentationAttributes, AllowsStyleAttributes permits SVGElementAdapter, org.tquadrat.foundation.svg.internal.SVGRectangleImpl
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Sets the start and end points for this line.
     *
     *  @param  x   The x coordinate for the upper left corner of the
     *      rectangle.
     *  @param  y  The y coordinate for the upper left corner of the
     *      rectangle.
     *  @param  width   The width of the rectangle.
     *  @param  height  The height of the rectangle.
     */
    public default void defineRectangle( final SVGNumber x, final SVGNumber y, final SVGNumber width, final SVGNumber height )
    {
        setX( requireNonNullArgument( x, "x" ) );
        setY( requireNonNullArgument( y, "y" ) );
        setWidth( requireNonNullArgument( width, "width" ) );
        setHeight( requireNonNullArgument( height, "height" ) );
    }   //  defineLine()

    /**
     *  Sets the height for this SVG {@code <rect>} element.
     *
     *  @param  value   The height.
     */
    public void setHeight( final SVGNumber value );

    /**
     *  Sets the length of the path represented by this SVG {@code <rect>}
     *  element.
     *
     *  @param  length  The author's computation of the total length of the
     *      path, in user units. This type is used to calibrate the user
     *      agent's own distance-along-a-path calculations with that of the
     *      author. The user agent will scale all distance-along-a-path
     *      computations by the ratio of this type to the user agent's own
     *      computed type for total path length.<br>
     *      <br>A type of zero is valid, but a negative type is an error.
     *
     *  @throws IllegalArgumentException    The type is less than 0.
     */
    public void setPathLength( final SVGUserUnitValue length );

    /**
     *  Sets the length of the path represented by this SVG {@code <rect>}
     *  element.
     *
     *  @param  length  The author's computation of the total length of the
     *      path, in user units. This type is used to calibrate the user
     *      agent's own distance-along-a-path calculations with that of the
     *      author. The user agent will scale all distance-along-a-path
     *      computations by the ratio of this type to the user agent's own
     *      computed type for total path length.<br>
     *      <br>A type of zero is valid, but a negative type is an error.
     *
     *  @throws IllegalArgumentException    The type is less than 0.
     */
    public default void setPathLength( final double length ) { setPathLength( number( length ) ); }

    /**
     *  Sets the length of the path represented by this SVG {@code <rect>}
     *  element.
     *
     *  @param  length  The author's computation of the total length of the
     *      path, in user units. This type is used to calibrate the user
     *      agent's own distance-along-a-path calculations with that of the
     *      author. The user agent will scale all distance-along-a-path
     *      computations by the ratio of this type to the user agent's own
     *      computed type for total path length.<br>
     *      <br>A type of zero is valid, but a negative type is an error.
     *
     *  @throws IllegalArgumentException    The type is less than 0.
     */
    public default void setPathLength( final long length ) { setPathLength( number( length ) ); }

    /**
     *  Sets the horizontal corner radius for this SVG {@code <rect>} element.
     *
     *  @param  value   The horizontal corner radius.
     */
    public void setRx( final SVGNumber value );

    /**
     *  Sets the vertical corner radius for this SVG {@code <rect>} element.
     *
     *  @param  value   The vertical corner radius.
     */
    public void setRy( final SVGNumber value );

    /**
     *  Sets the width for this SVG {@code <rect>} element.
     *
     *  @param  value   The width.
     */
    public void setWidth( final SVGNumber value );

    /**
     *  Sets the x coordinate for the upper left corner of the rectangle.
     *
     *  @param  value   The x coordinate.
     */
    public void setX( final SVGNumber value );

    /**
     *  Sets the y coordinate for the upper left corner of the rectangle.
     *
     *  @param  value   The y coordinate.
     */
    public void setY( final SVGNumber value );
}
//  interface SVGRectangle

/*
 *  End of File
 */