package com.poc.springbatch.core;

import lombok.*;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JexlFilterPredicate implements Predicate {
        @Getter(AccessLevel.NONE)
        @Setter(AccessLevel.NONE)
        private JexlEngine engine;
        private String variable;
        private HashMap<String, Object> mappedObjects;
        private String expressionToEvaluate;
        @Getter(AccessLevel.NONE)
        @Setter(AccessLevel.NONE)
        private JexlExpression e;
        private boolean alternate = false;

        public JexlFilterPredicate(HashMap<String, Object> pVars, String variable, String expression) {
            this.engine = new JexlBuilder().cache(512).strict(true).silent(false).create();
            this.mappedObjects = pVars;
            this.variable = variable;
            this.alternate = false;
            this.expressionToEvaluate = expression;
        }

        public JexlFilterPredicate(String variable, String expression) {
            this(null, variable, expression);
        }

        @Override
        public boolean evaluate(Object o) {
            Boolean b = this.standard_evaluate(o);
            if (!b && alternate) {
                b = this.others_evaluate(o);
            }
            return b.booleanValue();
        }

        private boolean others_evaluate(Object o) {
            JexlContext jc = new MapContext();
            String expression = this.expressionToEvaluate.replace(this.variable, o.toString());
            try {
                this.e = this.engine.createExpression(expression);
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la création de l'expression Jexl", e);
            }
            jc.set(variable, o);
            if (this.mappedObjects != null) {
                for (String item : this.mappedObjects.keySet()) {
                    jc.set(item, this.mappedObjects.get(item));
                }
            }
            Boolean b;
            try {
                b = (Boolean) e.evaluate(jc);
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de l'évaluation de l'expression Jexl", e);
            }
            return b.booleanValue();
        }

        private boolean standard_evaluate(Object o) {
            JexlContext jc = new MapContext();
            String expression = this.expressionToEvaluate;
            try {
                this.e = this.engine.createExpression(expression);
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la création de l'expression Jexl", e);
            }
            jc.set(variable, o);
            if (this.mappedObjects != null) {
                for (String item : this.mappedObjects.keySet()) {
                    jc.set(item, this.mappedObjects.get(item));
                }
            }
            Boolean b;
            try {
                b = (Boolean) e.evaluate(jc);
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de l'évaluation de l'expression Jexl", e);
            }
            return b.booleanValue();
        }
}
