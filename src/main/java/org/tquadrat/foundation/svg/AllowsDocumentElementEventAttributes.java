/*
 * ============================================================================
 * Copyright © 2002-2023 by Thomas Thrien.
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
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_OnCopy;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_OnCut;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_OnPaste;

import java.util.List;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;

/**
 *  SVG elements that allow the document element event attributes
 *  {@value SVGUtils#SVGATTRIBUTE_OnCopy},
 *  {@value SVGUtils#SVGATTRIBUTE_OnCut},
 *  and
 *  {@value SVGUtils#SVGATTRIBUTE_OnPaste}
 *  will implement this interface.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: AllowsDocumentElementEventAttributes.java 1074 2023-10-02 12:05:06Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: AllowsDocumentElementEventAttributes.java 1074 2023-10-02 12:05:06Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface AllowsDocumentElementEventAttributes
    permits SVG, SVGElementAdapter
{
        /*------------------------*\
    ====** Static Initialisations **===========================================
        \*------------------------*/
    /**
     *  The document element event attributes.
     */
    @SuppressWarnings( "StaticCollection" )
    public static final List<String> DOCUMENTELEMENTEVENT_ATTRIBUTES = List.of(
        SVGATTRIBUTE_OnCopy,
        SVGATTRIBUTE_OnCut,
        SVGATTRIBUTE_OnPaste
    );

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Sets the copy handler for this SVG element.
     *
     *  @param  value   The copy handler.
     *
     *  @see SVGUtils#SVGATTRIBUTE_OnCopy
     */
    public void setCopyHandler( final String value );

    /**
     *  Sets the cut handler for this SVG element.
     *
     *  @param  value   The cut handler.
     *
     *  @see SVGUtils#SVGATTRIBUTE_OnCut
     */
    public void setCutHandler( final String value );

    /**
     *  Sets the paste handler for this SVG element.
     *
     *  @param  value   The paste handler.
     *
     *  @see SVGUtils#SVGATTRIBUTE_OnPaste
     */
    public void setPasteHandler( final String value );
}
//  interface AllowsDocumentElementEventAttributes

/*
 *  End of File
 */