/*
 * ============================================================================
 * Copyright © 2002-2020 by Thomas Thrien.
 * All Rights Reserved.
 * ============================================================================
 *
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

/**
 *  Some SVG related stuff for the Foundation library set.
 *
 *  @todo task.list
 */
module org.tquadrat.foundation.svg
{
    requires java.base;
    requires transitive jakarta.activation;

    //---* The foundation modules *--------------------------------------------
    requires transitive org.tquadrat.foundation.xml;

    //---* The exports *-------------------------------------------------------
    exports org.tquadrat.foundation.svg;
    exports org.tquadrat.foundation.svg.type;
}

/*
 *  End of File
 */