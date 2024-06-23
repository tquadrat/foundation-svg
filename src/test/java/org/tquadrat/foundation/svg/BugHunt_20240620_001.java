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

package org.tquadrat.foundation.svg;

import static java.lang.System.out;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.writeString;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.tquadrat.foundation.lang.CommonConstants.UTF8;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.createText;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.type.SVGUnit.EM;

import java.nio.file.Path;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.svg.SVG.Usage;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.testutil.TestBaseClass;

/**
 *  Revise the header for the SVG output.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 */
@DisplayName( "org.tquadrat.foundation.svg.BugHunt_20240620_001" )
public class BugHunt_20240620_001 extends TestBaseClass
{
        /*---------------*\
    ====** Inner Classes **====================================================
        \*---------------*/

        /*-----------*\
    ====** Constants **========================================================
        \*-----------*/

        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/

        /*------------------------*\
    ====** Static Initialisations **===========================================
        \*------------------------*/

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Create the SVG document.
     *
     *  @param  usage   The intended usage of the generated document.
     *  @return The created document.
     */
    private final SVG createDocument( final Usage usage )
    {
        final var retValue = createSVG( usage );
        retValue.setDimension( number( 300 ), number( 300 ) );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createDocument()

    /**
     *  Generates output files from
     *  {@link Text#toSVG()}.
     *
     *  @throws Exception   Something unexpected went wrong.
     */
    @Test
    final void generateOutput() throws Exception
    {
        skipThreadTest();

        final var outputFolder = Path.of( ".", "src", "test", "output" ).toAbsolutePath().normalize();
        out.printf( "Output Folder: %s%n", outputFolder.toString() );
        assumeTrue( exists( outputFolder ) && isDirectory( outputFolder ) );
        out.printf( "Output Folder: %s%n", outputFolder.toString() );

        SVG document;
        var counter = 0;

        for( final var usage : Usage.values() )
        {
            document = createDocument( usage );
            final var text = createText( document, usage.name() );
            text.setDy( new SVGNumber( 1, EM ) );
            writeString( outputFolder.resolve( "%s_%03d.svg".formatted( getClass().getSimpleName(), ++counter ) ), document.toString(), UTF8, WRITE, CREATE, TRUNCATE_EXISTING );
        }
    }   //  generateOutput()
}
//  class BugHunt_20240620_001

/*
 *  End of File
 */