package com.doubleclick.asm;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class DoubleClickClassVistor extends ClassVisitor {


    private String className;
    private String superName;
    private String[] interfaces;

    public DoubleClickClassVistor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.className = name;
        this.superName = superName;
        this.interfaces=interfaces;
        System.out.println(this.interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println("ClassVisitor visitMethod name-------" + name + ", superName is " + superName);
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
//        if (interfaces!=null&&interfaces.length>0){
//            for (String interfaceName:interfaces){
//                if (interfaceName.contains("OnClickListener")){
//                    System.out.println(" + name + ", superName is " + superName);
////                    if (name.startsWith("onClick")) {
////                        //处理onCreate()方法
////                        return new DoubleClickMethodVistor(mv, className, name);
////                    }
//                }
//            }
//        }

        if ((name.equals("onClick")||name.equals("doClick")) && //
                desc.equals("(Landroid/view/View;)V")) {
            return new DoubleClickMethodVistor(mv, className, name);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
