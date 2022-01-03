/*
 * ============================================================================
 * Copyright © 2002-2018 by Thomas Thrien.
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

package org.tquadrat.foundation.svg.internal;

import static org.apiguardian.api.API.Status.INTERNAL;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Id;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_LengthAdjust;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Rotate;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_TextAnchor;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_TextLength;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Transform;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_dx;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_dy;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_x;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_y;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Anchor;
import static org.tquadrat.foundation.svg.SVGUtils.SVGELEMENT_Text;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.ANIMATION;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.DESCRIPTIVE;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.TEXT_CONTENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.AllowsConditionalProcessingAttributes;
import org.tquadrat.foundation.svg.AllowsGraphicalEventAttributes;
import org.tquadrat.foundation.svg.AllowsPresentationAttributes;
import org.tquadrat.foundation.svg.AllowsStyleAttributes;
import org.tquadrat.foundation.svg.SVGText;

/**
 *  The implementation of the interface
 *  {@link SVGText}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGTextImpl.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGTextImpl.java 820 2020-12-29 20:34:22Z tquadrat $" )
@API( status = INTERNAL, since = "0.0.5" )
public final class SVGTextImpl extends SVGTextBase implements SVGText
{
        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code SVGTextImpl} instance.
     */
    public SVGTextImpl()
    {
        super( SVGELEMENT_Text );

        //---* The children and attributes for the <text> element *------------
        final Collection<String> childElements = new HashSet<>();
        childElements.addAll( ANIMATION.getElements() );
        childElements.addAll( DESCRIPTIVE.getElements() );
        childElements.addAll( TEXT_CONTENT.getElements() );
        childElements.addAll( List.of( SVGELEMENT_Anchor ) );

        final Collection<String> attributes = new ArrayList<>();
        attributes.addAll( List.of( SVGATTRIBUTE_Id, SVGATTRIBUTE_x,
            SVGATTRIBUTE_y, SVGATTRIBUTE_dx, SVGATTRIBUTE_dy,
            SVGATTRIBUTE_TextAnchor, SVGATTRIBUTE_Rotate,
            SVGATTRIBUTE_TextLength, SVGATTRIBUTE_LengthAdjust,
            SVGATTRIBUTE_Transform ) );
        attributes.addAll( AllowsConditionalProcessingAttributes.CONDITIONALPROCESSING_ATTRIBUTES );
        attributes.addAll( CORE_ATTRIBUTES );
        attributes.addAll( AllowsGraphicalEventAttributes.GRAPHICALEVENT_ATTRIBUTES );
        attributes.addAll( AllowsStyleAttributes.STYLE_ATTRIBUTES );
        attributes.addAll( AllowsPresentationAttributes.PRESENTATION_ATTRIBUTES );

        updateRegistries( childElements, attributes );
    }   //  SVGTextImpl()
}
//  class SVGTextImpl

/*
 *  End of File
 */