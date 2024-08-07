/*

Copyright 2010, Google Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

    * Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above
copyright notice, this list of conditions and the following disclaimer
in the documentation and/or other materials provided with the
distribution.
    * Neither the name of Google Inc. nor the names of its
contributors may be used to endorse or promote products derived from
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,           
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY           
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/

package com.google.refine.browsing;

import com.google.refine.model.Project;
import com.google.refine.model.Record;

/**
 * Interface for visiting records one by one. The records visited are only those that match some particular criteria,
 * such as facets' constraints.
 */
public interface RecordVisitor {

    public void start(Project project); // called before any visit() call

    /**
     * @deprecated use {@link #visit(Project, int, Record)}
     */
    @Deprecated(since = "3.9")
    public boolean visit(
            Project project,
            Record record);

    /**
     * @param project
     *            project the record is part of
     * @param sortedStartRowIndex
     *            zero-based sorted index of the first row in the record
     * @param record
     *            the record to visit
     * @return true to abort visitation early - no further visit calls will be made
     * @since 3.9
     */
    public default boolean visit(
            Project project,
            int sortedStartRowIndex,
            Record record) {
        return visit(project, record);
    }

    public void end(Project project); // called after all visit() calls
}
