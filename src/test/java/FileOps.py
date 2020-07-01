# --** coding="UTF-8" **--
#
import os
import re
import sys
'''
文件传参执行如下
cmd 执行 python G:\WorkCodeExample\src\test\java\FileOps.py G://WorkCodeExample//src//test//java//textfile
默认main python G:\WorkCodeExample\src\test\java\FileOps.py
'''
class changeFilename:
    def __init__(self,sourcePath):
        self.path=sourcePath
        os.chdir(self.path)

    def rename(path,newName):
        oldpath = path
        pos1 = path.find('_num_')
        pos2 = path.find('_',pos1+5)
        # newpath = path[:pos1]+path[pos2:]
        newName=newName+".docx"
        os.rename(path,newName)  # 对文件进行重命名]

    def update(self,folderName):
        # fileList = os.listdir(r"./textfile")
        fileList=os.listdir(self.path)
        # # 输出此文件夹中包含的文件名称
        # print("原文件：" + str(fileList))
        # # 得到进程当前工作目录
        # currentpath = os.getcwd()
        # # 将当前工作目录修改为待修改文件夹的位置
        # os.chdir(self.path)
        # # 名称变量
        # # num = 1
        #TODO当前文件放前面，文件夹放后面
        num=0;
        for fileName in fileList:
            if os.path.isdir(os.path.join(self.path, fileName)):
                num=5
            if os.path.isfile(os.path.join(self.path, fileName)):
                num=1

        # 遍历文件夹中所有文件
        for fileName in fileList:
            try:
                file_path = os.path.join(self.path, fileName)  # 获取绝对路径
                if os.path.isdir(file_path):  # 判断是否是文件夹
                    self.path=file_path
                    folderName=fileName#子文件夹名称
                    changeFilename.update(self,folderName)  # 如果是文件夹，就递归调用自己;
                else:
                    extension_name = os.path.splitext(file_path)  # 将文件的绝对路径中的后缀名分离出来
                    if extension_name[1] == '.docx':
                        changeFilename.rename(file_path,(extension_name[0]+folderName))
            except:
                continue

            # # # 切片获取文件扩展名,因为docx的长度为4，如果是doc格式，那么长度就为3,以此类推
            # if fileName[-4::] == 'docx':
            #     # 匹配文件名正则表达式
            #     pat = ".+\.(docx)"
            #     # 进行匹配
            #     pattern = re.findall(pat, fileName)
            #     #原文件名+部门
            #     oldName=(fileName.split('.')[0])+'第二事业部'
            #     print("新文件名:", oldName)
            #     # 文件重新命名
            #     os.rename(fileName, (oldName+'.docx'))
            #     # 改变编号，继续下一项
            #     # num = num + 1

        # print("***************************************")
        # # 改回程序运行前的工作目录
        # os.chdir(currentpath)
        # # 刷新
        # sys.stdin.flush()
        # # 输出修改后文件夹中包含的文件名称
        # print("旧文件：" + str(os.listdir(self.path)))


# def rename_file(file_dir):
#     for root, dirs, files in os.walk(file_dir):
#         print(1,root) #当前目录路径
#         print(2,dirs) #当前路径下所有子目录list
#         print(3,files) #当前路径下所有非目录子文件 list
#         print("")
#
#         # 1、先处理当前目录下的文件
#         for file_name in files:
#             if "[www.17zixueba.com]" in file_name:
#                 old_file_path = root + "\\" + file_name
#                 new_file_name = file_name.replace('[www.17zixueba.com]', '')
#                 new_file_path = root + "\\" + new_file_name
#                 print('old_file_path:',old_file_path)
#                 print('new_file_path:',new_file_path)
#                 os.rename(old_file_path, new_file_path)
#
#         # 2、递归处理目录下的子目录及子目录中的文件
#         for dir_name in dirs:
#             old_dir_path = root + "\\" + dir_name
#
#             if "[www.17zixueba.com]" in dir_name:
#                 new_dir_name = dir_name.replace('[www.17zixueba.com]', '')
#                 new_dir_path = root + "\\" + new_dir_name
#                 print("old_dir_path:",old_dir_path)
#                 print("new_dir_path:",new_dir_path)
#                 os.rename(old_dir_path, new_dir_path)
#                 dir_path = new_dir_path
#             else:
#                 dir_path = old_dir_path
#
#
#             rename_file(dir_path)
#
# path = "I:\技术\教程\Python\数据分析与挖掘\python数据分析全套"
# # path = "E:\python数据分析全套"
# rename_file(path)

if __name__ == "__main__":
    sourceFilePath = "G://WorkCodeExample//src//test//java//textfile"    # 目标路径
    rootFolderName ="textfile"#当前根目录文件夹名称
    changeFilename(sourceFilePath).update(rootFolderName)
