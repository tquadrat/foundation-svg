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

package org.tquadrat.foundation.svg.type;

import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.lang.Objects.requireNonNullArgument;
import static org.tquadrat.foundation.svg.type.SVGUnit.MILLIMETER;
import static org.tquadrat.foundation.svg.type.SVGUnit.NONE;
import static org.tquadrat.foundation.svg.type.SVGUnit.PERCENT;
import static org.tquadrat.foundation.svg.type.SVGUnit.PIXEL;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;

/**
 *  A numeric type with a unit as used by various SVG attributes.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed class SVGNumber
    permits SVGNumber.SVGDegree, SVGNumber.SVGMillimeter, SVGNumber.SVGPercent,
        SVGNumber.SVGPixel, SVGNumber.SVGUserUnitValue
{
        /*---------------*\
    ====** Inner Classes **====================================================
        \*---------------*/
    /**
     *  An SVG degrees type.
     *
     *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
     *  @version $Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
     *  @since 0.0.5
     *
     *  @UMLGraph.link
     */
    @SuppressWarnings( {"PublicInnerClass", "MagicNumber"} )
    @ClassVersion( sourceVersion = "$Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
    @API( status = STABLE, since = "0.0.5" )
    public static final class SVGDegree extends SVGNumber
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGDegree} instance.
         *
         *  @param  value   The type.
         */
        public SVGDegree( final double value ) { super( value % 360.0, NONE ); }

        /**
         *  Creates a new {@code SVGDegree} instance.
         *
         *  @param  value   The type.
         */
        public SVGDegree( final long value ) { super( value % 360L, NONE ); }
    }
    //  class SVGDegree

    /**
     *  An SVG millimeter type.
     *
     *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
     *  @version $Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
     *  @since 0.0.5
     *
     *  @see SVGUnit#MILLIMETER
     *
     *  @UMLGraph.link
     */
    @SuppressWarnings( "PublicInnerClass" )
    @ClassVersion( sourceVersion = "$Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
    @API( status = STABLE, since = "0.0.5" )
    public static final class SVGMillimeter extends SVGNumber
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGMillimeter} instance.
         *
         *  @param  value   The type.
         */
        public SVGMillimeter( final double value ) { super( value, MILLIMETER ); }

        /**
         *  Creates a new {@code SVGMillimeter} instance.
         *
         *  @param  value   The type.
         */
        public SVGMillimeter( final long value ) { super( value, MILLIMETER ); }
    }
    //  class SVGMillimeter

    /**
     *  An SVG percent type.
     *
     *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
     *  @version $Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
     *  @since 0.0.5
     *
     *  @see SVGUnit#PERCENT
     *
     *  @UMLGraph.link
     */
    @SuppressWarnings( "PublicInnerClass" )
    @ClassVersion( sourceVersion = "$Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
    @API( status = STABLE, since = "0.0.5" )
    public static final class SVGPercent extends SVGNumber
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGPercent} instance.
         *
         *  @param  value   The type.
         */
        public SVGPercent( final double value ) { super( value, PERCENT ); }

        /**
         *  Creates a new {@code SVGPercent} instance.
         *
         *  @param  value   The type.
         */
        public SVGPercent( final long value ) { super( value, PERCENT ); }
    }
    //  class SVGPercent

    /**
     *  An SVG pixel type.
     *
     *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
     *  @version $Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
     *  @since 0.0.5
     *
     *  @see SVGUnit#PIXEL
     *
     *  @UMLGraph.link
     */
    @SuppressWarnings( "PublicInnerClass" )
    @ClassVersion( sourceVersion = "$Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
    @API( status = STABLE, since = "0.0.5" )
    public static final class SVGPixel extends SVGNumber
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGPixel} instance.
         *
         *  @param  value   The type.
         */
        public SVGPixel( final double value ) { super( value, PIXEL ); }

        /**
         *  Creates a new {@code SVGPixel} instance.
         *
         *  @param  value   The type.
         */
        public SVGPixel( final long value ) { super( value, PIXEL ); }
    }
    //  class SVGPixel

    /**
     *  An SVG user unit type; usually this is the same as
     *  {@link SVGNumber.SVGPixel}, but without a unit specifier.
     *
     *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
     *  @version $Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
     *  @since 0.0.5
     *
     *  @see SVGUnit#NONE
     *
     *  @UMLGraph.link
     */
    @SuppressWarnings( "PublicInnerClass" )
    @ClassVersion( sourceVersion = "$Id: SVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
    @API( status = STABLE, since = "0.0.5" )
    public static final class SVGUserUnitValue extends SVGNumber
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGUserUnitValue} instance.
         *
         *  @param  value   The type.
         */
        public SVGUserUnitValue( final double value ) { super( value, NONE ); }

        /**
         *  Creates a new {@code SVGUserUnitValue} instance.
         *
         *  @param  value   The type.
         */
        public SVGUserUnitValue( final long value ) { super( value, NONE ); }
    }
    //  class SVGUserUnitValue

        /*-----------*\
    ====** Constants **========================================================
        \*-----------*/
    /**
     *  An empty array of {@code SVGNumber} objects.
     */
    public static final SVGNumber [] EMPTY_SVGNumber_ARRAY = new SVGNumber [0];

    /**
     *  An empty array of {@code SVGDegree} objects.
     */
    @SuppressWarnings( "ClassReferencesSubclass" )
    public static final SVGDegree [] EMPTY_SVGDegree_ARRAY = new SVGDegree [0];

        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/
    /**
     *  Flag that indicates whether the type is an integer ({@code int}) - as
     *  in opposite to a {@code double}). There it does not matter that the
     *  decimal places of a {@code double} are effectively zero.
     */
    private final boolean m_IsInteger;

    /**
     *  Flag that indicates whether the type is a negative number.
     */
    private final boolean m_IsNegative;

    /**
     *  Flag that indicates whether the type is zero.
     */
    private final boolean m_IsZero;

    /**
     *  The type.
     */
    private final String m_Value;

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code SVGNumber} instance.
     *
     *  @param  value   The type.
     *  @param  unit    The unit.
     */
    public SVGNumber( final double value, final SVGUnit unit )
    {
        m_Value = requireNonNullArgument( unit, "unit" ).format( value );
        m_IsInteger = false;
        m_IsNegative = value < 0.0;
        m_IsZero = value == 0.0;
    }   //  SVGNumber()

    /**
     *  Creates a new {@code SVGNumber} instance.
     *
     *  @param  value   The type.
     *  @param  unit    The unit.
     */
    public SVGNumber( final long value, final SVGUnit unit )
    {
        m_Value = requireNonNullArgument( unit, "unit" ).format( value );
        m_IsInteger = true;
        m_IsNegative = value < 0;
        m_IsZero = value == 0;
    }   //  SVGNumber()

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  {@inheritDoc}
     */
    @SuppressWarnings( "AccessingNonPublicFieldOfAnotherObject" )
    @Override
    public final boolean equals( final Object obj )
    {
        var retValue = this == obj;
        if( !retValue && (obj instanceof SVGNumber other) && (getClass() == other.getClass()) )
        {
            retValue = m_Value.equals( other.m_Value );
        }

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  equals()

    /**
     *  {@inheritDoc}
     */
    @Override
    public final int hashCode() { return m_Value.hashCode(); }

    /**
     *  Returns a flag that indicates whether the type is an integer
     *  ({@code int}) - as in opposite to a {@code double}). There it does not
     *  matter that the decimal places of a {@code double} are effectively
     *  zero.
     *
     *  @return {@code true} if the type is an integer, {@code false}
     *      otherwise.
     */
    public final boolean isInteger() { return m_IsInteger; }

    /**
     *  Returns a flag that indicates whether the type is a negative number.
     *
     *  @return {@code true} if the type is less than zero, {@code false}
     *      otherwise.
     */
    public final boolean isNegative() { return m_IsNegative; }

    /**
     *  Returns a flag that indicates whether the type is zero.
     *
     *  @return {@code true} if the type is 0 (or 0.0), {@code false}
     *      otherwise.
     */
    public final boolean isZero() { return m_IsZero; }

    /**
     *  {@inheritDoc}
     */
    @Override
    public final String toString() { return value(); }

    /**
     *  Return the type with the unit for this instance.
     *
     *  @return The type with unit.
     */
    public final String value() { return m_Value; }
}
//  class SVGNumber

/*
 *  End of File
 */