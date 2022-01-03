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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Defs;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Description;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Root;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_TSpan;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Text;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Title;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Use;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.retrieveElementCategory;
import static org.tquadrat.foundation.util.StringUtils.format;

import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.EmptyArgumentException;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the class
 *  {@link SVGElementCategory}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGElementCategory.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGElementCategory.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.type.TestSVGElementCategory" )
public class TestSVGElementCategory extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Calls the methods of
     *  {@link SVGElementCategory}
     *  to reach the test coverage ratio.
     */
    @Test
    final void cover()
    {
        skipThreadTest();

        for( final var value : SVGElementCategory.values() )
        {
            assertNotNull( value.toString() );
            final var valueName = value.name();
            assertNotEquals( valueName, value.toString() );
            assertNotNull( SVGElementCategory.valueOf( valueName ) );
            assertEquals( value, SVGElementCategory.valueOf( valueName ) );

            assertFalse( value.getElements().isEmpty() );
        }
    }   //  cover()

    /**
     *  Tests for the method
     *  {@link SVGElementCategory#retrieveElementCategory(String)}
     */
    @Test
    final void testRetrieveElementCategory()
    {
        skipThreadTest();

        Collection<SVGElementCategory> categories;

        categories = retrieveElementCategory( SVGELEMENT_Defs );
        assertFalse( categories.isEmpty() );

        categories = retrieveElementCategory( SVGELEMENT_Description );
        assertFalse( categories.isEmpty() );

        categories = retrieveElementCategory( SVGELEMENT_Root );
        assertFalse( categories.isEmpty() );

        categories = retrieveElementCategory( SVGELEMENT_Text );
        assertFalse( categories.isEmpty() );

        categories = retrieveElementCategory( SVGELEMENT_Title );
        assertFalse( categories.isEmpty() );

        categories = retrieveElementCategory( SVGELEMENT_TSpan );
        assertFalse( categories.isEmpty() );

        categories = retrieveElementCategory( SVGELEMENT_Use );
        assertFalse( categories.isEmpty() );
    }   //  testRetrieveElementCategory()

    /**
     *  Tests for the method
     *  {@link SVGElementCategory#retrieveElementCategory(String)}
     */
    @Test
    final void testRetrieveElementCategoryWithEmptyArgument()
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = EmptyArgumentException.class;
        try
        {
            retrieveElementCategory( EMPTY_STRING );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testRetrieveElementCategoryWithEmptyArgument()

    /**
     *  Tests for the method
     *  {@link SVGElementCategory#retrieveElementCategory(String)}
     */
    @Test
    final void testRetrieveElementCategoryWithNullArgument()
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            retrieveElementCategory( null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testRetrieveElementCategoryWithNullArgument()
}
//  class TestSVGElementCategory

/*
 *  End of File
 */