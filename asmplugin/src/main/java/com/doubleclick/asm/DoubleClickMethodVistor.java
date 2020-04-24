package com.doubleclick.asm;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

public class DoubleClickMethodVistor extends MethodVisitor {
    private String className;
    private String methodName;
    boolean ignore = false;

    public DoubleClickMethodVistor(MethodVisitor methodVisitor, String className, String methodName) {
        super(Opcodes.ASM5, methodVisitor);
        this.className = className;
        this.methodName = methodName;
    }

    //方法执行前插入
    @Override
    public void visitCode() {
        super.visitCode();
        System.out.println("MethodVisitor visitCode------");
        if (ignore){
           super.visitCode();
           return;
        }

        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKESTATIC, "com/example/asm/DoubleClickHelper", "shouldDoClick", "(Landroid/view/View;)Z", false);
        Label label = new Label();
        mv.visitJumpInsn(IFNE, label);
        mv.visitInsn(RETURN);
        mv.visitLabel(label);
        super.visitCode();
//        mv.visitInsn(Opcodes.POP);
    }


    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {

        /*Lcom/smartdengg/clickdebounce/Debounced;*/
        ignore = desc.equals("Lcom/example/asm/ignore;");

        return super.visitAnnotation(desc, visible);

    }
}