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

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;

/**
 *  Possible values for the SVG attribute
 *  {@value org.tquadrat.foundation.svg.SVGUtils#SVGATTRIBUTE_TextAnchor}.
 *
 *  @see org.tquadrat.foundation.svg.SVGUtils#SVGATTRIBUTE_TextAnchor
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGTextAnchor.java 980 2022-01-06 15:29:19Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGTextAnchor.java 980 2022-01-06 15:29:19Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public enum SVGTextAnchor
{
        /*------------------*\
    ====** Enum Declaration **=================================================
        \*------------------*/
    /**
     *  Inherit alignment from parent.
     */
    @API( status = STABLE, since = "0.0.5" )
    INHERIT( "inherit" ),

    /**
     *  Align to end.
     */
    @API( status = STABLE, since = "0.0.5" )
    END( "end" ),

    /**
     *  Align to the middle.
     */
    @API( status = STABLE, since = "0.0.5" )
    MIDDLE( "middle" ),

    /**
     *  Align to the start.
     */
    @API( status = STABLE, since = "0.0.5" )
    START( "start" );

        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/
    /**
     *  The attribute type.
     */
    private final String m_AttributeValue;

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code SVGAlignmentBaseLine} instance.
     *
     *  @param  attributeValue  The attribute type.
     */
    private SVGTextAnchor( final String attributeValue )
    {
        m_AttributeValue = attributeValue;
    }   //  SVGAlignmentBaseLine()

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  {@inheritDoc}
     */
    @Override
    public final String toString() { return m_AttributeValue; }
}
//  enum SVGTextAnchor

/*
 *  End of File
 */