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

package org.tquadrat.foundation.svg.svgutils;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVGUtils.closePath;
import static org.tquadrat.foundation.svg.SVGUtils.createPath;
import static org.tquadrat.foundation.svg.SVGUtils.hLineTo;
import static org.tquadrat.foundation.svg.SVGUtils.lineTo;
import static org.tquadrat.foundation.svg.SVGUtils.moveToAbs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGElementWithChildren;
import org.tquadrat.foundation.svg.SVGPath;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGPathElement;

/**
 *  Tests for the methods
 *  {@link SVGUtils#createPath()},
 *  {@link SVGUtils#createPath(SVGElementWithChildren)}
 *  {@link SVGUtils#createPath(SVGPathElement...)},
 *  and
 *  {@link SVGUtils#createPath(SVGElementWithChildren, SVGPathElement...)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreatePath.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "CommentedOutCode" )
@ClassVersion( sourceVersion = "$Id: TestCreatePath.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreatePath" )
public class TestCreatePath extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Test the methods
     *  {@link SVGUtils#createPath()},
     *  {@link SVGUtils#createPath(SVGElementWithChildren)}
     *  {@link SVGUtils#createPath(SVGPathElement...)},
     *  and
     *  {@link SVGUtils#createPath(SVGElementWithChildren, SVGPathElement...)}.
     */
    @Test
    final void testCreatePath()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGPath.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        SVGPathElement [] path;

        String actual, expected;
        SVGPath candidate;

        candidate = createPath();
        expected = "\n<path/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createPath( parent );
        expected = "\n<path/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        path = new SVGPathElement [] {moveToAbs( 0, 0 ), lineTo( 10, 10 ), hLineTo( 20 ), closePath()};

        candidate = createPath( path );
        expected = "\n<path d='M0,0 l10,10 h20 Z'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createPath( parent, path );
        expected = "\n<path d='M0,0 l10,10 h20 Z'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        path = new SVGPathElement [0];

        candidate = createPath( path );
        expected = "\n<path d=''/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createPath( parent, path );
        expected = "\n<path d=''/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testCreatePath()

    /**
     *  Test the methods
     *  {@link SVGUtils#createPath(SVGElementWithChildren)}
     *  {@link SVGUtils#createPath(SVGPathElement...)}
     *  and
     *  {@link SVGUtils#createPath(SVGElementWithChildren, SVGPathElement...)}.
     */
    @DisplayName( "SVGUtils.createPath() with null attribute" )
    @Test
    final void testCreatePathWithNullArgument()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGPath.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createPath( (SVGPathElement []) null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
        try
        {
            createPath( (SVGElementWithChildren) null, closePath() );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
        try
        {
            createPath( parent, (SVGPathElement []) null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreatePathWithNullArgument()
}
//  class TestCreatePath

/*
 *  End of File
 */