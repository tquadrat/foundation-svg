/*
 * ============================================================================
 *  Copyright © 2002-2024 by Thomas Thrien.
 *  All Rights Reserved.
 * ============================================================================
 *  Licensed to the public under the agreements of the GNU Lesser General Public
 *  License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.tquadrat.foundation.svg.type;

import static java.util.Arrays.stream;
import static org.apiguardian.api.API.Status.INTERNAL;
import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.lang.Objects.isNull;
import static org.tquadrat.foundation.lang.Objects.requireNonNullArgument;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.tquadrat.foundation.lang.Objects;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.annotation.UtilityClass;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.exception.PrivateConstructorForStaticClassCalledError;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGMillimeter;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPercent;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPixel;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue;

/**
 *  <p>{@summary The class {@code SVGCalculator} provide functions to perform
 *  calculations on instances of
 *  {@link SVGNumber }
 *  and its subclasses.}</p>
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGCalculator.java 1140 2024-06-23 11:17:41Z tquadrat $
 *  @since 0.4.7
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGCalculator.java 1140 2024-06-23 11:17:41Z tquadrat $" )
@API( status = STABLE, since = "0.4.7" )
@UtilityClass
public final class SVGCalculator
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  No instance allowed for this class!
     */
    private SVGCalculator() { throw new PrivateConstructorForStaticClassCalledError( SVGCalculator.class ); }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Adds the given values.
     *
     *  @param  <T> The type of the values.
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The sum.
     *
     *  @since  0.4.8
     */
    @SafeVarargs
    @API( status = STABLE, since = "0.4.8" )
    public static final <T extends SVGNumber> T add( final T v1, final T... vOther )
    {
        var sum = requireNonNullArgument( v1, "v1" ).number().doubleValue();
        final var unit = v1.unit();
        for( final var v : vOther )
        {
            if( unit != v.unit() ) throw new IllegalArgumentException( "Invalid unit: %s".formatted( v.unit().name() ) );
            sum += v.number().doubleValue();
        }
        @SuppressWarnings( "unchecked" )
        final var retValue = (T) switch( unit )
        {
            case PIXEL -> new SVGPixel( sum );
            case MILLIMETER -> new SVGMillimeter( sum );
            case PERCENT -> new SVGPercent( sum );
            default -> v1 instanceof SVGDegree ? new SVGDegree( sum ) : new SVGNumber( sum, unit );
        };

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  add

    /**
     *  Adds the given values.
     *
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The sum.
     *
     *  @since  0.4.8
     */
    @API( status = STABLE, since = "0.4.8" )
    public static final SVGDegree add( final SVGDegree v1, final SVGDegree... vOther )
    {
        final var sum = requireNonNullArgument( v1, "v1" ).number().doubleValue() + stream( vOther ).filter( Objects::nonNull ).mapToDouble( v -> v.number().doubleValue() ).sum();
        final var retValue = new SVGDegree( sum );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  add

    /**
     *  Adds the given values.
     *
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The sum.
     *
     *  @since  0.4.8
     */
    @API( status = STABLE, since = "0.4.8" )
    public static final SVGMillimeter add( final SVGMillimeter v1, final SVGMillimeter... vOther )
    {
        final var sum = requireNonNullArgument( v1, "v1" ).number().doubleValue() + stream( vOther ).filter( Objects::nonNull ).mapToDouble( v -> v.number().doubleValue() ).sum();
        final var retValue = new SVGMillimeter( sum );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  add

    /**
     *  Adds the given values.
     *
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The sum.
     *
     *  @since  0.4.8
     */
    @API( status = STABLE, since = "0.4.8" )
    public static final SVGPixel add( final SVGPixel v1, final SVGPixel... vOther )
    {
        final var sum = requireNonNullArgument( v1, "v1" ).number().doubleValue() + stream( vOther ).filter( Objects::nonNull ).mapToDouble( v -> v.number().doubleValue() ).sum();
        final var retValue = new SVGPixel( sum );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  add

    /**
     *  Adds the given values.
     *
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The sum.
     *
     *  @since  0.4.8
     */
    @API( status = STABLE, since = "0.4.8" )
    public static final SVGPercent add( final SVGPercent v1, final SVGPercent... vOther )
    {
        final var sum = requireNonNullArgument( v1, "v1" ).number().doubleValue() + stream( vOther ).filter( Objects::nonNull ).mapToDouble( v -> v.number().doubleValue() ).sum();
        final var retValue = new SVGPercent( sum );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  add

    /**
     *  Increases the given instance of
     *  {@link SVGNumber}
     *  by the given increment and returns the result.
     *
     *  @param  <T> The type of the value.
     *  @param  value   The value.
     *  @param  increment   The increment.
     *  @return The result.
     */
    @API( status = STABLE, since = "0.4.7" )
    public static final <T extends SVGNumber> T increase( final T value, final double increment )
    {
        final var amount = requireNonNullArgument( value, "value" ).number().doubleValue() + increment;
        final var retValue = newNumber( value, amount );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  increase()

    /**
     *  Returns a list built from the given values.
     *
     *  @param  <T> The type of the values.
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The list from the given values.
     *  @throws IllegalArgumentException    Not all values will have the same
     *      unit.
     */
    @API( status = INTERNAL, since = "0.4.10" )
    @SafeVarargs
    private static final <T extends SVGNumber> List<T> makeList( final T v1, final T... vOther ) throws IllegalArgumentException
    {
        final List<T> retValue = new ArrayList<>();
        final var unit = requireNonNullArgument( v1, "v1" ).unit();
        retValue.add( v1 );
        for( final var v : requireNonNullArgument( vOther, "vOther" ) )
        {
            if( isNull( v ) ) throw new NullArgumentException();
            if( unit != v.unit() ) throw new IllegalArgumentException( "Invalid unit: %s".formatted( v.unit().name() ) );
            retValue.add( v );
        }

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  makeList()

    /**
     *  Returns the greatest one of the given values.
     *
     *  @param  <T> The type of the values.
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The greatest value from the given values.
     *  @throws IllegalArgumentException    Not all values will have the same
     *      unit.
     *
     *  @since  0.4.10
     */
    @SafeVarargs
    @API( status = STABLE, since = "0.4.10" )
    public static final <T extends SVGNumber> T max( final T v1, final T... vOther ) throws IllegalArgumentException
    {
        final var buffer = makeList( v1, vOther );
        buffer.sort( Comparator.naturalOrder() );
        final var retValue = buffer.getLast();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  max()

    /**
     *  Returns the smallest one of the given values.
     *
     *  @param  <T> The type of the values.
     *  @param  v1  The first value.
     *  @param  vOther  The other values.
     *  @return The smallest value from the given values.
     *  @throws IllegalArgumentException    Not all values will have the same
     *      unit.
     *
     *  @since  0.4.10
     */
    @SafeVarargs
    @API( status = STABLE, since = "0.4.10" )
    public static final <T extends SVGNumber> T min( final T v1, final T... vOther ) throws IllegalArgumentException
    {
        final var buffer = makeList( v1, vOther );
        buffer.sort( Comparator.naturalOrder() );
        final var retValue = buffer.getFirst();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  min()

    /**
     *  Multiplies the given instance of
     *  {@link SVGNumber}
     *  with the given factor and returns the result.
     *
     *  @param  <T> The type of the value.
     *  @param  value   The value.
     *  @param  factor  The factor.
     *  @return The result.
     */
    @API( status = STABLE, since = "0.4.7" )
    public static final <T extends SVGNumber> T multiply( final T value, final double factor )
    {
        final var amount = requireNonNullArgument( value, "value" ).number().doubleValue() * factor;
        final var retValue = newNumber( value, amount );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  multiply()

    /**
     *  Creates a new instance of
     *  {@link SVGNumber}
     *  with the given type and amount.
     *
     *  @param  <T> The type of the value.
     *  @param  value   The value.
     *  @param  amount  The amount.
     *  @return The result.
     */
    @SuppressWarnings( "unchecked" )
    @API( status = INTERNAL, since = "0.4.7" )
    private static final <T extends SVGNumber> T newNumber( final T value, final double amount )
    {
        final var retValue = switch( requireNonNullArgument( value, "value" ) )
        {
            case final SVGDegree $ -> (T) new SVGDegree( amount );
            case final SVGMillimeter $ -> (T) new SVGMillimeter( amount );
            case final SVGPercent $ -> (T) new SVGPercent( amount );
            case final SVGPixel $ -> (T) new SVGPixel( amount );
            case final SVGUserUnitValue $ -> (T) new SVGUserUnitValue( amount );
            default -> (T) new SVGNumber( amount, value.unit() );
        };

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  newNumber()

    /**
     *  Reduces the given instance of
     *  {@link SVGNumber}
     *  by the given decrement and returns the result.
     *
     *  @param  <T> The type of the value.
     *  @param  value   The value.
     *  @param  decrement   The decrement.
     *  @return The result.
     */
    @API( status = STABLE, since = "0.4.7" )
    public static final <T extends SVGNumber> T reduce( final T value, final double decrement )
    {
        final var amount = requireNonNullArgument( value, "value" ).number().doubleValue() - decrement;
        final var retValue = newNumber( value, amount );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  reduce()

    /**
     *  Returns an instance of
     *  {@link SVGMillimeter}
     *  whose value corresponds with that of the given value.
     *
     *  @param  input   The input value.
     *  @return The corresponding value as {@code SVGMillimeter}.
     *  @throws IllegalArgumentException    The given value cannot be converted
     *      to an instance of {@code SVGMillimeter}.
     */
    @SuppressWarnings( {"OverlyComplexMethod", "NestedSwitchStatement"} )
    @API( status = STABLE, since = "0.4.7" )
    public static final SVGMillimeter toMillimeter( final SVGNumber input )
    {
        final var retValue = switch( input )
        {
            case null -> throw new NullArgumentException( "input" );
            case final SVGDegree ignored -> throw new IllegalArgumentException( "Cannot convert SVGDegree to millimeter" );
            case final SVGPercent ignored -> throw new IllegalArgumentException( "Cannot convert SVGPercent to millimeter" );
            case final SVGMillimeter value -> value;
            case final SVGPixel value -> new SVGMillimeter( value.number().doubleValue() * 25.4 / 96.0 );
            case final SVGUserUnitValue value -> new SVGMillimeter( value.number().doubleValue() * 25.4 / 96.0 );
            default -> switch( input.unit() )
            {
                case INCH -> new SVGMillimeter( input.number().doubleValue() * 25.4 );
                case PICA -> new SVGMillimeter( input.number().doubleValue() * 12.7 / 3.0 );
                case POINT -> new SVGMillimeter( input.number().doubleValue() * 0.352778 );
                case CENTIMETER -> input.isInteger()
                    ? new SVGMillimeter( input.number().longValue() * 10 )
                    : new SVGMillimeter( input.number().doubleValue() *10.0 );
                case MILLIMETER -> input.isInteger()
                    ? new SVGMillimeter( input.number().longValue() )
                    : new SVGMillimeter( input.number().doubleValue() );
                case PIXEL -> new SVGMillimeter( input.number().doubleValue() * 25.4 / 96.0 );
                default -> throw new IllegalArgumentException( "Cannot convert %s to millimeter".formatted( input.unit().name() ) );
            };
        };

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  toMillimeter()

    /**
     *  Returns an instance of
     *  {@link SVGPixel}
     *  whose value corresponds with that of the given value.
     *
     *  @param  input   The input value.
     *  @return The corresponding value as {@code SVGMPixel}.
     *  @throws IllegalArgumentException    The given value cannot be converted
     *      to an instance of {@code SVGPixel}.
     */
    @SuppressWarnings( {"OverlyComplexMethod", "NestedSwitchStatement"} )
    @API( status = STABLE, since = "0.4.7" )
    public static final SVGPixel toPixel( final SVGNumber input )
    {
        final var retValue = switch( input )
        {
            case null -> throw new NullArgumentException( "input" );
            case final SVGDegree ignored -> throw new IllegalArgumentException( "Cannot convert SVGDegree to millimeter" );
            case final SVGPercent ignored -> throw new IllegalArgumentException( "Cannot convert SVGPercent to millimeter" );
            case final SVGMillimeter value -> new SVGPixel( value.number().doubleValue() * 96.0 / 25.4 );
            case final SVGPixel value -> value;
            case final SVGUserUnitValue value -> value.isInteger()
                ? new SVGPixel( value.number().longValue() )
                : new SVGPixel( value.number().doubleValue() );
            default -> switch( input.unit() )
            {
                case INCH -> new SVGPixel( input.number().doubleValue() * 96.0 );
                case PICA -> new SVGPixel( input.number().doubleValue() * 16.0 );
                case POINT -> new SVGPixel( input.number().doubleValue() * 6.0 / 8.0 );
                case CENTIMETER -> new SVGPixel( input.number().doubleValue() * 960.0 / 25.4 );
                case MILLIMETER -> new SVGPixel( input.number().doubleValue() * 96.0 / 25.4 );
                case PIXEL -> input.isInteger()
                    ? new SVGPixel( input.number().longValue() )
                    : new SVGPixel( input.number().doubleValue() );
                default -> throw new IllegalArgumentException( "Cannot convert %s to millimeter".formatted( input.unit().name() ) );
            };
        };

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  toMillimeter()
}
//  class SVGCalculator

/*
 *  End of File
 */