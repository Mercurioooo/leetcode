classZRootsIterator{
private:
ZOopStorageIterator _vm_weak_handles_iter;
ZOopStorageIterator _jni_handles_iter;
ZOopStorageIterator _jni_weak_handles_iter;
ZOopStorageIterator _string_table_iter;
void do_universe(OopClosure* cl);
void do_vm_weak_handles(OopClosure* cl);
void do_jni_handles(OopClosure* cl);
void do_jni_weak_handles(OopClosure* cl);
void do_object_synchronizer(OopClosure* cl);
void do_management(OopClosure* cl);
void do_jvmti_export(OopClosure* cl);
void do_jvmti_weak_export(OopClosure* cl);
void do_jfr_weak(OopClosure* cl);
void do_system_dictionary(OopClosure* cl);
void do_class_loader_data_graph(OopClosure* cl);
void do_threads(OopClosure* cl);
void do_code_cache(OopClosure* cl);
void do_string_table(OopClosure* cl);
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_universe> _universe;
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_object_synchronizer> _object_synchronizer;
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_management> _management;
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_jvmti_export> _jvmti_export;
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_jvmti_weak_export> _jvmti_weak_export;
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_jfr_weak> _jfr_weak;
ZSerialOopsDo<ZRootsIterator,&ZRootsIterator::do_system_dictionary> _system_dictionary;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_vm_weak_handles> _vm_weak_handles;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_jni_handles> _jni_handles;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_jni_weak_handles> _jni_weak_handles;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_class_loader_data_graph> _class_loader_data_graph;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_threads> _threads;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_code_cache> _code_cache;
ZParallelOopsDo<ZRootsIterator,&ZRootsIterator::do_string_table> _string_table;
public:
ZRootsIterator();
~ZRootsIterator();
void oops_do(OopClosure* cl,bool visit_jvmti_weak_export =false);
};