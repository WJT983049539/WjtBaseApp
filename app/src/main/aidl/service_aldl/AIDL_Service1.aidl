// AIDL_Service1.aidl
package service_aldl;

// Declare any non-default types here with import statements

interface AIDL_Service1 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
            //AIDL中支持以下的数据类型
            //1. 基本数据类型
            //2. String 和CharSequence
            //3. List 和 Map ,List和Map 对象的元素必须是AIDL支持的数据类型;
            //4. AIDL自动生成的接口（需要导入-import）
            //5. 实现android.os.Parcelable 接口的类（需要导入-import)
            void AIDL_Service(String string);

}
