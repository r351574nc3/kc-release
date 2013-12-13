/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.web.struts.action;

import java.util.ArrayList;

import org.kuali.rice.kns.question.QuestionBase;

/**
 * This class support the ConfirmationQuestion. For example: a Yes/No/Cancel dialog window.
 */

public class KcConfirmationQuestion extends QuestionBase {

    public static final String YES = "0";
    public static final String NO = "1";
    public static final String CANCEL = "2";

    @SuppressWarnings("unchecked")
    public KcConfirmationQuestion() {
        super("Are you sure you want to cancel?", new ArrayList(3));
        this.getButtons().add("Yes");
        this.getButtons().add("No");
        this.getButtons().add("returntodocument");
    }
}
