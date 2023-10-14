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

import static java.lang.Character.isWhitespace;
import static java.lang.String.format;
import static java.lang.System.err;
import static java.lang.System.out;
import static org.tquadrat.foundation.lang.CommonConstants.UTF8;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.createSVGDocument;
import static org.tquadrat.foundation.svg.SVGUtils.createTSpan;
import static org.tquadrat.foundation.svg.SVGUtils.createText;
import static org.tquadrat.foundation.svg.SVGUtils.createUse;
import static org.tquadrat.foundation.svg.SVGUtils.degree;
import static org.tquadrat.foundation.svg.SVGUtils.em;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.annotation.PlaygroundClass;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;

/**
 *  A test program that uses all the implemented features of the SVG library
 *  to create an SVG document in a file.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGTester.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@PlaygroundClass
@ClassVersion( sourceVersion = "$Id: SVGTester.java 1076 2023-10-03 18:36:07Z tquadrat $" )
public final class SVGTester
{
        /*-----------*\
    ====** Constants **========================================================
        \*-----------*/
    /**
     *  The name of the output file: {@value}.
     */
    public static final String FILE_NAME = "data/SVGTest.svg";

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates an instance of {@code SVGTester}.
     */
    private SVGTester() { /* Just exists … */ }

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  The program entry point.
     *
     *  @param  args    The command line arguments.
     */
    @SuppressWarnings( {"ThrowCaughtLocally", "ProhibitedExceptionThrown", "NestedTryStatement"} )
    public static void main( final String... args )
    {
        try
        {
            //---* Get the output file *---------------------------------------
            final var outputFile = new File( ".", FILE_NAME ).getCanonicalFile().getAbsoluteFile();
            out.printf( "Output File: %s\n", outputFile.getAbsolutePath() );
            //noinspection ResultOfMethodCallIgnored
            outputFile.getParentFile().mkdirs();

            //---* Create the root element *-----------------------------------
            final var rootElement = createSVG( STANDALONE_DOCUMENT );

            //---* Create the SVG document *-----------------------------------
            final var document = createSVGDocument( rootElement );

            //---* Create a template text *------------------------------------
            final var templateText = createText();
            templateText.setId( "templateText" );
            templateText.setTitle( "Template Text" );
            templateText.addText( "This is a template text" );
            var tspan = createTSpan( templateText );
            tspan.addText( "This is the second line of the template Text" );
            tspan.setDy( em( 1 ) );
            tspan = createTSpan( templateText );
            tspan.addText( "This is the third line of the template Text" );
            tspan.setDy( em( 1 ));

            rootElement.addDefinition( templateText );

            //---* Creates a text element *------------------------------------
            final var description = "This SVG document was created to demonstrate the capabilities of the Foundation SVG library";
            final var text = createText( rootElement );
            text.setDescription( description );
            text.addText( description );
            final List<SVGDegree> rotations = new ArrayList<>();
            var counter = 0;
            for( var i = 0; i < description.length(); ++i )
            {
                final var c = description.charAt( i );
                if( isWhitespace( c ) )
                {
                    rotations.add( degree( 0 ) );
                }
                else if( ++counter % 2 == 0 )
                {
                    rotations.add( degree( -30 ) );
                }
                else
                {
                    rotations.add( degree( 30 ) );
                }
            }
            if( description.length() != rotations.size() ) throw new Error( format( "Rotations: %d - Description: %d\n", rotations.size(), description.length() ) );
            text.setRotate( rotations.toArray( SVGDegree[]::new ) );
            text.setX( pixel( 20 ) );
            text.setY( pixel( 20 ) );

            //---* Use the template text *-------------------------------------
            final var use = createUse( rootElement, URI.create( "#templateText" ) );
            use.setTitle( "Template Text Reference" );
            use.setX( pixel( 20 ) );
            use.setY( pixel( 100 ) );

            //---* Write the document *----------------------------------------
            try( final var writer = new FileWriter( outputFile, UTF8 ) )
            {
                writer.write( document.toString( true ) );
            }
            out.println( document.toString( true ) );
        }
        catch( final Throwable t )
        {
            //---* Handle any previously unhandled exceptions *----------------
            t.printStackTrace( err );
        }

        out.println( "Done!" );
    }   //  main()
}
//  class SVGTester

/*
 *  End of File
 */